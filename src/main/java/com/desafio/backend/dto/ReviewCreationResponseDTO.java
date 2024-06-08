package com.desafio.backend.dto;


import java.time.LocalDate;
import java.util.UUID;

public record ReviewCreationResponseDTO(UUID id, String text, Double rating, Long movieId, LocalDate watchedAt, UserLoginResponseDTO user, String poster_path, String release_date) {}
