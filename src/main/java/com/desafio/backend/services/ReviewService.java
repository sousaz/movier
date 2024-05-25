package com.desafio.backend.services;

import com.desafio.backend.entities.Reviews;
import com.desafio.backend.repositories.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewsRepository reviewRepository;

    public ReviewService(ReviewsRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Reviews createReview(Reviews review){
        return reviewRepository.save(review);
    }

    public List<Reviews> listAllReviews(){
        return reviewRepository.findAll();
    }
}
