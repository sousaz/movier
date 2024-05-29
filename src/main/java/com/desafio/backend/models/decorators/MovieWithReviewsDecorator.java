package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieWithReviewsDecorator extends MovieDecorator{
    private List<ReviewCreationResponseDTO> reviews = new ArrayList<>();
    public MovieWithReviewsDecorator(Movie decoratorMovie, List<ReviewCreationResponseDTO> reviews) {
        super(decoratorMovie);
        this.reviews = reviews;
    }
}
