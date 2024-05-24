package com.desafio.backend.middlewares.auth;

import com.desafio.backend.entities.Users;
import com.desafio.backend.repositories.UserRepository;

public class UsernameMiddleware extends Middleware{

    private final UserRepository userRepository;

    public UsernameMiddleware(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Users check(Users user) {
        Users userFound = userRepository.findByUsername(user.getUsername());
        if(userFound == null)
            return null;
        return checkNext(userFound);
    }
}
