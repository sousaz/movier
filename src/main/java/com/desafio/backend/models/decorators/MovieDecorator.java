package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;

import java.util.List;

public abstract class MovieDecorator implements Movie {
    protected Movie decoratorMovie;

    public MovieDecorator(Movie decoratorMovie){
        this.decoratorMovie = decoratorMovie;
    }

    @Override
    public String getTitle() {
        return decoratorMovie.getTitle();
    }

    @Override
    public String getOverview() {
        return decoratorMovie.getOverview();
    }

    @Override
    public String getReleaseDate() {
        return decoratorMovie.getReleaseDate();
    }

    @Override
    public String getPosterPath() {
        return decoratorMovie.getPosterPath();
    }

    @Override
    public String getOriginalTitle() {
        return decoratorMovie.getOriginalTitle();
    }

    @Override
    public Long getId() {
        return decoratorMovie.getId();
    }

    @Override
    public boolean isFavorited() {
        return decoratorMovie.isFavorited();
    }

    @Override
    public List<ReviewCreationResponseDTO> getReviews() {
        return decoratorMovie.getReviews();
    }

}
