package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieWithReviewsDecorator extends MovieDecorator{
    private List<ReviewCreationResponseDTO> reviews = new ArrayList<>();
    public MovieWithReviewsDecorator(Movie decoratorMovie, List<ReviewCreationResponseDTO> reviews) {
        super(decoratorMovie);
        this.reviews = reviews;
    }

    public List<ReviewCreationResponseDTO> getReviews() {
        return reviews;
    }

    public boolean isFavorited() {
        return super.isFavorited();
    }

}
