package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

@Getter
public class MovieWithFavoriteDecorator extends MovieDecorator {
    private boolean favorited = false;
    public MovieWithFavoriteDecorator(Movie decoratorMovie, boolean favorited) {
        super(decoratorMovie);
        this.favorited = favorited;
    }
}
