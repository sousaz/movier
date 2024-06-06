package com.desafio.backend.models.factory;

import com.desafio.backend.interfaces.Movie;
import com.desafio.backend.models.MovieApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BasicMovie implements Movie {
    private Long id;
    @JsonProperty("poster_path")
    private String posterPath;
    private String title;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    private double averageRating;

    public BasicMovie(MovieApiResponse movie) {
        this.id = movie.getId();
        this.posterPath = movie.getPosterPath();
        this.title = movie.getTitle();
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.releaseDate = movie.getReleaseDate();
        this.averageRating = movie.getAverageRating();
    }
}
