package com.desafio.backend.dto;

import java.time.LocalDate;

public record WatchedDTO(Long user, Long movieId, String poster_path, LocalDate watched_at, String release_date, double rating, boolean favorited) {
}
