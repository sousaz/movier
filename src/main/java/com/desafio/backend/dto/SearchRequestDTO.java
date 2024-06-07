package com.desafio.backend.dto;

import java.util.UUID;

public record SearchRequestDTO(String  search, UUID userId) {
}
