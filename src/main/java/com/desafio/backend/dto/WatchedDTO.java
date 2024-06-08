package com.desafio.backend.dto;

import java.time.LocalDate;
import java.util.UUID;

public record WatchedDTO(UUID user, Long movieId, String poster_path, LocalDate watched_at, String release_date, double rating, boolean favorited) {
}
