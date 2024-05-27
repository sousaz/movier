package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("movieWithFavorite")
public class MovieWithFavoriteDecorator extends MovieDecorator {
    private boolean favorited = false;
    public MovieWithFavoriteDecorator(Movie decoratorMovie, boolean favorited) {
        super(decoratorMovie);
        this.favorited = favorited;
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

    public boolean isFavorited() {
        return favorited;
    }

    public List<ReviewCreationResponseDTO> getReviews() {
        return super.getReviews();
    }
}
