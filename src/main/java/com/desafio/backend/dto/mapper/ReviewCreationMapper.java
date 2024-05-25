package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.ReviewCreationRequestDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewCreationMapper {

    private final UserLoginMapper userMapper;

    public ReviewCreationMapper(UserLoginMapper userMapper){
        this.userMapper = userMapper;
    }
    public Reviews toEntity(ReviewCreationRequestDTO reviewDTO, Users user){
        if(reviewDTO == null)
            return null;
        Reviews review = new Reviews();
        review.setMovieId(reviewDTO.movieId());
        review.setRating(reviewDTO.rating());
        review.setText(reviewDTO.text());
        review.setWatchedAt(reviewDTO.watchedAt());
        review.setUser(user);
        return review;
    }

    public ReviewCreationResponseDTO toDTO(Reviews review){
        if(review == null)
            return null;
        return new ReviewCreationResponseDTO(review.getId(), review.getText(), review.getRating(), review.getMovieId(), review.getWatchedAt(), userMapper.toDTO(review.getUser()));
    }
}
