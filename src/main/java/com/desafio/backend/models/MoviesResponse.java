package com.desafio.backend.models;

import com.desafio.backend.interfaces.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MoviesResponse {
    List<Movie> movies;
}
