package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.entities.Favorites;
import com.desafio.backend.entities.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FavoriteToggleMapper {
    public Favorites toEntity(FavoriteToggleDTO favoriteToggleDTO, Users user) {
        if(favoriteToggleDTO == null)
            return null;
        Favorites favorite = new Favorites();
        favorite.setMovieId(favoriteToggleDTO.movieId());
        favorite.setUser(user);
        favorite.setPoster_Path(favoriteToggleDTO.poster_path());
        return favorite;
    }

    public FavoriteToggleDTO toDTO(Favorites favorite) {
        if(favorite == null)
            return null;
        return new FavoriteToggleDTO(favorite.getUser().getId(), favorite.getMovieId(), favorite.getPoster_Path());
    }

    public List<FavoriteToggleDTO> toDTOs(List<Favorites> favorite) {
        if(favorite == null)
            return null;
        return favorite.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
