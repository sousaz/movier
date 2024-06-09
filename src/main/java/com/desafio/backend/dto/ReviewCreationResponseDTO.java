package com.desafio.backend.dto;


import java.time.LocalDate;

public record ReviewCreationResponseDTO(Long id, String text, Double rating, Long movieId, LocalDate watchedAt, UserLoginResponseDTO user, String poster_path, String release_date) {}
