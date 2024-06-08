package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.ReviewCreationRequestDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        review.setPoster_Path(reviewDTO.poster_path());
        review.setRelease_date(reviewDTO.release_date());
        return review;
    }

    public ReviewCreationResponseDTO toDTO(Reviews review){
        if(review == null)
            return null;
        return new ReviewCreationResponseDTO(review.getId(), review.getText(), review.getRating(), review.getMovieId(), review.getWatchedAt(), userMapper.toDTO(review.getUser()), review.getPoster_Path(), review.getRelease_date());
    }

    public List<ReviewCreationResponseDTO> toDTOs(List<Reviews> reviews){
        return reviews.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
