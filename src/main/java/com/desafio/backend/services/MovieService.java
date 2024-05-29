package com.desafio.backend.services;

import com.desafio.backend.interfaces.Movie;
import com.desafio.backend.models.BasicMovie;
import com.desafio.backend.models.decorators.MovieWithFavoriteDecorator;
import com.desafio.backend.models.decorators.MovieWithReviewsDecorator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.backend.models.Details;
import com.desafio.backend.models.Movies;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${apiKey}")
    private String apiKey;
    @Value("${apiToken}")
    private String apiToken;

    public Movies listMostPopularMovie(){
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=pt-BR";
        return makeRequest(url, Movies.class);
    }

    public List<Movie> listMostPopularMovie1(){
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=pt-BR";
        Movies movies = makeRequest(url, Movies.class);
        List<Movie> moviesResponse = new ArrayList<>();
        movies.getMovies().forEach(movie -> {
            Movie movieProcess = new BasicMovie(movie);
            movieProcess = new MovieWithFavoriteDecorator(movieProcess, true);
            if(movie.getId() == 823464){
                movieProcess = new MovieWithReviewsDecorator(movieProcess, new ArrayList<>());
            }
            moviesResponse.add(movieProcess);
        });
        return moviesResponse;
    }

    public Details getDetailsOfMovie(Long id){
        String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey+"&language=pt-BR";
        return makeRequest(url, Details.class);
    }

    public Movies searchMovies(String value){
        String url = "https://api.themoviedb.org/3/search/movie?query="+value+"&language=pt-BR?api_key="+apiKey;
        return makeRequest(url, Movies.class);
    }

    private <T> T makeRequest(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType).getBody();
    }
}
