package com.desafio.backend.controllers;

import com.desafio.backend.interfaces.Movie;
import org.springframework.web.bind.annotation.*;

import com.desafio.backend.models.Details;
import com.desafio.backend.services.MovieService;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public List<Movie> listMostPopularMovie(@PathVariable UUID id) {
        return movieService.listMostPopularMovie(id);
    }

//    @GetMapping("/{id}")
//    public Details getDetailsOfMovie(@PathVariable Long id){
//        return movieService.getDetailsOfMovie(id);
//    }

//    @PostMapping
//    public Movies searchMovies(@RequestBody BasicMovie movie){
//        return movieService.searchMovies(movie.getTitle());
//    }
    
}
