package com.desafio.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieApiResponse {
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
}
