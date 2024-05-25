package com.desafio.backend.controllers;

import com.desafio.backend.dto.UserLoginRequestDTO;
import com.desafio.backend.dto.UserLoginResponseDTO;
import com.desafio.backend.exceptions.InvalidCredentialsException;
import com.desafio.backend.entities.Users;
import com.desafio.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserLoginResponseDTO register(@RequestBody UserLoginRequestDTO user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO user){
            return userService.login(user);
    }
}
