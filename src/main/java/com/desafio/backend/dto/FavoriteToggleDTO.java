package com.desafio.backend.dto;

import java.util.UUID;

public record FavoriteToggleDTO(UUID userId, Long movieId) {}
