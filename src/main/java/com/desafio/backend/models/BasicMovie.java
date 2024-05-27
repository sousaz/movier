package com.desafio.backend.models;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonTypeName("basicMovie")
public class BasicMovie implements Movie{
    private Long id;
    @JsonProperty("poster_path")
    private String posterPath;
    private String title;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;

    public BasicMovie(MovieApiResponse movie) {
        this.id = movie.getId();
        this.posterPath = movie.getPosterPath();
        this.title = movie.getTitle();
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.releaseDate = movie.getReleaseDate();
    }

    @Override
    public boolean isFavorited() {
        return false;
    }

    @Override
    public List<ReviewCreationResponseDTO> getReviews() {
        return new ArrayList<>();
    }
}
