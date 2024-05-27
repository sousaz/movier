package com.desafio.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.desafio.backend.interfaces.Movie;

import lombok.Data;

@Data
public class Movies {
    @JsonProperty("results")
    private List<MovieApiResponse> movies;
}
