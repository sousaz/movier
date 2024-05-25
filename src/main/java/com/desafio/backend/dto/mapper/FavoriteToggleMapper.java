package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.entities.Favorites;
import com.desafio.backend.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class FavoriteToggleMapper {
    public Favorites toEntity(FavoriteToggleDTO favoriteToggleDTO, Users user) {
        if(favoriteToggleDTO == null)
            return null;
        Favorites favorite = new Favorites();
        favorite.setMovieId(favoriteToggleDTO.movieId());
        favorite.setUser(user);
        return favorite;
    }
}
