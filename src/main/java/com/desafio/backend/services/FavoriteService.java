package com.desafio.backend.services;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.dto.mapper.FavoriteToggleMapper;
import com.desafio.backend.entities.Favorites;
import com.desafio.backend.entities.Users;
import com.desafio.backend.exceptions.UsernameAlreadyExistsException;
import com.desafio.backend.repositories.FavoritesRepository;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FavoriteService {
    private final FavoritesRepository favoriteRepository;
    private final UserRepository userRepository;

    private final FavoriteToggleMapper favoriteMapper;

    public FavoriteService(FavoritesRepository favoriteRepository, UserRepository userRepository, FavoriteToggleMapper favoriteMapper) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.favoriteMapper = favoriteMapper;
    }
    public Favorites toggleFavorite(FavoriteToggleDTO favorites) {
        Favorites favorite = favoriteRepository.findByMovieIdAndUserId(favorites.movieId(), favorites.userId());
        if(favorite != null) {
            favoriteRepository.delete(favorite);
            return null;
        }
        Users user = userRepository.findById(favorites.userId());
        try {
            return favoriteRepository.save(favoriteMapper.toEntity(favorites, user));
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Error while toggling favorite");
        }
    }

    public boolean getFavorite(UUID userId, Long movieId) {
        Favorites favorite = favoriteRepository.findByMovieIdAndUserId(movieId, userId);
        return favorite != null;
    }
}
