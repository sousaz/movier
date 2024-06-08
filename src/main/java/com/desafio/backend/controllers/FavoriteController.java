package com.desafio.backend.controllers;

import com.desafio.backend.dto.FavoriteToggleDTO;
import com.desafio.backend.entities.Favorites;
import com.desafio.backend.exceptions.UsernameAlreadyExistsException;
import com.desafio.backend.services.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void toggleFavorite(@RequestBody FavoriteToggleDTO favorites) {
        this.favoriteService.toggleFavorite(favorites);
    }

}
