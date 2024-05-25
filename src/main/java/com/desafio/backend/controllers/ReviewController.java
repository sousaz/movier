package com.desafio.backend.controllers;

import com.desafio.backend.dto.ReviewCreationRequestDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewCreationResponseDTO createReview(@RequestBody ReviewCreationRequestDTO review){
        return this.reviewService.createReview(review);
    }

    @GetMapping("/list")
    public List<Reviews> listAllReviews(){
        return this.reviewService.listAllReviews();
    }
}
