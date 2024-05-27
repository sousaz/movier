package com.desafio.backend.interfaces;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.models.BasicMovie;
import com.desafio.backend.models.decorators.MovieWithFavoriteDecorator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicMovie.class, name = "basicMovie"),
        @JsonSubTypes.Type(value = MovieWithFavoriteDecorator.class, name = "movieWithFavorite")
})
public interface Movie {
    Long getId();
    String getTitle();
    String getOverview();
    String getReleaseDate();
    String getPosterPath();
    String getOriginalTitle();


    boolean isFavorited();
    List<ReviewCreationResponseDTO> getReviews();

}
