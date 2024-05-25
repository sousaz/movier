package com.desafio.backend.services;

import com.desafio.backend.dto.ReviewCreationRequestDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.dto.mapper.ReviewCreationMapper;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import com.desafio.backend.repositories.ReviewsRepository;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewsRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewCreationMapper reviewMapper;

    public ReviewService(ReviewsRepository reviewRepository, ReviewCreationMapper reviewCreationMapper, UserRepository userRepository){
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewCreationMapper;
        this.userRepository = userRepository;
    }

    public ReviewCreationResponseDTO createReview(ReviewCreationRequestDTO review){
        Users user = userRepository.findById(review.userId());
        Reviews foundReview = reviewRepository.findByMovieIdAndUserId(review.movieId(), user.getId());
        Reviews newReview = reviewMapper.toEntity(review, user);
        if(foundReview != null){
            foundReview.setRating(newReview.getRating());
            foundReview.setText(newReview.getText());
            foundReview.setWatchedAt(newReview.getWatchedAt());
            foundReview.setMovieId(newReview.getMovieId());
            foundReview.setRating(newReview.getRating());
            foundReview.setUser(user);
            return reviewMapper.toDTO(reviewRepository.save(foundReview));

        }
        return reviewMapper.toDTO(reviewRepository.save(newReview));
    }

    public List<Reviews> listAllReviews(){
        return reviewRepository.findAll();
    }
}
