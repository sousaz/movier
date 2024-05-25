package com.desafio.backend.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ReviewCreationRequestDTO(String text, Double rating, Long movieId, LocalDate watchedAt, UUID userId){}
