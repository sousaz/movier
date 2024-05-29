package com.desafio.backend.models.decorators;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;

import java.util.List;
@Getter
public abstract class MovieDecorator implements Movie {
    protected Movie decoratorMovie;

    public MovieDecorator(Movie decoratorMovie){
        this.decoratorMovie = decoratorMovie;
    }
}
