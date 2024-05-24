package com.desafio.backend.controllers;

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
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users user){
            return userService.login(user);
    }
}
