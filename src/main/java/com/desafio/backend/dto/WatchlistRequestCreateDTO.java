package com.desafio.backend.dto;


public record WatchlistRequestCreateDTO(Long userId, Long movieId, String poster_path, String title) {
}
