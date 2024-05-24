package com.desafio.backend.services;

import com.desafio.backend.exceptions.InvalidCredentialsException;
import com.desafio.backend.entities.Users;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Users register(Users user) {
        return userRepository.save(user);
    }

    public Users login(Users user){
        Users userFound = userRepository.findByUsername(user.getUsername());
        if(userFound != null && userFound.getPassword().equals(user.getPassword())){
            return userFound;
        }
        throw new InvalidCredentialsException("Invalid username or password.");
    }
}
