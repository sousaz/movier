package com.desafio.backend.controllers;

import com.desafio.backend.interfaces.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.backend.models.Details;
import com.desafio.backend.services.MovieService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMostPopularMovie() {
        return movieService.listMostPopularMovie1();
    }

    @GetMapping("/{id}")
    public Details getDetailsOfMovie(@PathVariable Long id){
        return movieService.getDetailsOfMovie(id);
    }

//    @PostMapping
//    public Movies searchMovies(@RequestBody BasicMovie movie){
//        return movieService.searchMovies(movie.getTitle());
//    }
    
}
