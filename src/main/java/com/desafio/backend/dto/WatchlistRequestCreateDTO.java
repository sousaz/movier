package com.desafio.backend.dto;

import java.util.UUID;

public record WatchlistRequestCreateDTO(UUID userId, Long movieId, String poster_path) {
}
