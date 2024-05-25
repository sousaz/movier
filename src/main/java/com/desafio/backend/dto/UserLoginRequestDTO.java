package com.desafio.backend.dto;


import java.util.UUID;

public record UserLoginRequestDTO(UUID id, String username, String password){}
