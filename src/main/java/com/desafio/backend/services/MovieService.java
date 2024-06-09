package com.desafio.backend.services;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.dto.SearchRequestDTO;
import com.desafio.backend.dto.WatchedDTO;
import com.desafio.backend.dto.mapper.FavoriteToggleMapper;
import com.desafio.backend.dto.mapper.WatchedMapper;
import com.desafio.backend.entities.Favorites;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.interfaces.Movie;
import com.desafio.backend.models.MovieApiResponse;
import com.desafio.backend.models.factory.MovieFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.backend.models.Movies;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

@Service
public class MovieService {
    private RestTemplate restTemplate;
    private final ReviewService reviewService;
    private  final FavoriteService favoriteService;
    private final FavoriteToggleMapper favoriteMapper;

    private final WatchedMapper watchedMapper;

    public MovieService(RestTemplate restTemplate, ReviewService reviewService, FavoriteService favoriteService, FavoriteToggleMapper favoriteMapper, WatchedMapper watchedMapper){
        this.restTemplate = restTemplate;
        this.reviewService = reviewService;
        this.favoriteService = favoriteService;
        this.favoriteMapper = favoriteMapper;
        this.watchedMapper = watchedMapper;
    }

    @Value("${apiKey}")
    private String apiKey;
    @Value("${apiToken}")
    private String apiToken;

    public List<Movie> listMostPopularMovie(Long userId){
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=pt-BR";
        Movies movies = makeRequest(url, Movies.class);
        List<Movie> moviesResponse = new ArrayList<>();
        movies.getMovies().forEach(movie -> {
            boolean favorited = this.favoriteService.getFavorite(userId, movie.getId());
            List<ReviewCreationResponseDTO> reviews = this.reviewService.listAllReviewsByMovieId(movie.getId());
            movie.setAverageRating(this.reviewService.calculateAverageRating(movie.getId()));
            moviesResponse.add(MovieFactory.getinstance(movie, favorited, reviews));
        });
        return moviesResponse;
    }

    public Movie getDetailsOfMovie(Long id, Long userId){
        String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey+"&language=pt-BR";
        MovieApiResponse movie =  makeRequest(url, MovieApiResponse.class);
        boolean favorited = this.favoriteService.getFavorite(userId, movie.getId());
        List<ReviewCreationResponseDTO> reviews = this.reviewService.listAllReviewsByMovieId(movie.getId());
        movie.setAverageRating(this.reviewService.calculateAverageRating(movie.getId()));
        return MovieFactory.getinstance(movie, favorited, reviews);
    }

    public List<Movie> searchMovies(SearchRequestDTO search){
        String url = "https://api.themoviedb.org/3/search/movie?query="+search.search()+"&language=pt-BR?api_key="+apiKey;
        Movies movies = makeRequest(url, Movies.class);
        List<Movie> moviesResponse = new ArrayList<>();
        movies.getMovies().forEach(movie -> {
            boolean favorited = this.favoriteService.getFavorite(search.userId(), movie.getId());
            List<ReviewCreationResponseDTO> reviews = this.reviewService.listAllReviewsByMovieId(movie.getId());
            movie.setAverageRating(this.reviewService.calculateAverageRating(movie.getId()));
            moviesResponse.add(MovieFactory.getinstance(movie, favorited, reviews));
        });
        return moviesResponse;
    }

    public List<FavoriteToggleDTO> favoriteMovie(Long id){
        return this.favoriteMapper.toDTOs(this.favoriteService.favoriteMovies(id));
    }

    public List<WatchedDTO> watchedMovie(Long id){
        List<Reviews> reviews = this.reviewService.watchedMovies(id);
        List<WatchedDTO> watchedMovies = new ArrayList<>();
        reviews.forEach(review -> {
            boolean favorited = this.favoriteService.getFavorite(id, review.getMovieId());
            watchedMovies.add(watchedMapper.toDTO(review, favorited));
        });
        return watchedMovies;
    }

    private <T> T makeRequest(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType).getBody();
    }
}
