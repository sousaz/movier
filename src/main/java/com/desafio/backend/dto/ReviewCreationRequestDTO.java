package com.desafio.backend.dto;

import java.time.LocalDate;

public record ReviewCreationRequestDTO(String text, Double rating, Long movieId, LocalDate watchedAt, Long userId, String poster_path, String release_date){}
