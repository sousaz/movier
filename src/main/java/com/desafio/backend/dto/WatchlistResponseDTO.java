package com.desafio.backend.dto;

import java.util.UUID;

public record WatchlistResponseDTO(Long movieId, UUID userId, String poster_path) {
}
