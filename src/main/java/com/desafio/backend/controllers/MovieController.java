package com.desafio.backend.controllers;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.dto.SearchRequestDTO;
import com.desafio.backend.dto.WatchedDTO;
import com.desafio.backend.interfaces.Movie;
import org.springframework.web.bind.annotation.*;

import com.desafio.backend.services.MovieService;


import java.util.List;
import java.lang.Long;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public List<Movie> listMostPopularMovie(@PathVariable Long id) {
        return movieService.listMostPopularMovie(id);
    }

    @GetMapping("/{id}/{userId}")
    public Movie getDetailsOfMovie(@PathVariable Long id, @PathVariable Long userId){
        return movieService.getDetailsOfMovie(id, userId);
    }

    @PostMapping
    public List<Movie> searchMovies(@RequestBody SearchRequestDTO search){
        return movieService.searchMovies(search);
    }

    @GetMapping("/favorite/{id}")
    public List<FavoriteToggleDTO> favoriteMovie(@PathVariable Long id){
        return movieService.favoriteMovie(id);
    }

    @GetMapping("/watched/{id}")
    public List<WatchedDTO> watchedMovie(@PathVariable Long id){
        return movieService.watchedMovie(id);
    }
    
}
