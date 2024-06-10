package com.desafio.backend.services;

import com.desafio.backend.dto.UserLoginRequestDTO;
import com.desafio.backend.dto.UserLoginResponseDTO;
import com.desafio.backend.dto.mapper.UserLoginMapper;
import com.desafio.backend.exceptions.InvalidCredentialsException;
import com.desafio.backend.entities.Users;
import com.desafio.backend.exceptions.UsernameAlreadyExistsException;
import com.desafio.backend.middlewares.auth.Middleware;
import com.desafio.backend.middlewares.auth.PasswordMiddleware;
import com.desafio.backend.middlewares.auth.UsernameMiddleware;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.Long;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserLoginMapper userMapper;

    public UserService(UserRepository userRepository, UserLoginMapper userLoginMapper) {
        this.userRepository = userRepository;
        this.userMapper = userLoginMapper;
    }
    public UserLoginResponseDTO register(UserLoginRequestDTO user) {
        try {
            return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException(e.getMessage());
        }
    }
    public UserLoginResponseDTO login(UserLoginRequestDTO user){
        Middleware middleware = Middleware.link(
                new UsernameMiddleware(this),
                new PasswordMiddleware(userMapper.toEntity(user)));
        Users authenticatedUser = middleware.check(userMapper.toEntity(user));
        if(authenticatedUser != null)
            return userMapper.toDTO(authenticatedUser);
        throw new InvalidCredentialsException("Invalid username or password.");
    }

    public Users findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
