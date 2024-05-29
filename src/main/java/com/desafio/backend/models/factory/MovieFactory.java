package com.desafio.backend.models.factory;

import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.interfaces.Movie;
import com.desafio.backend.models.MovieApiResponse;

import java.util.List;

public class MovieFactory {
    private MovieFactory() {
    }

    public static Movie getinstance(MovieApiResponse movie, boolean favorited, List<ReviewCreationResponseDTO> reviews) {
        if(favorited && reviews != null)
            return new MovieWithFavoritedAndReview(movie, favorited, reviews);
        else if(favorited)
            return new MovieWithFavorited(movie, favorited);
        else if(reviews != null)
            return new MovieWithReview(movie, reviews);
        return new BasicMovie(movie);
    }
}
