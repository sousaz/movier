package com.desafio.backend.middlewares.auth;

import com.desafio.backend.entities.Users;
import com.desafio.backend.repositories.UserRepository;
import com.desafio.backend.services.UserService;

public class UsernameMiddleware extends Middleware{

    private final UserService userService;

    public UsernameMiddleware(UserService userService){
        this.userService = userService ;
    }

    @Override
    public Users check(Users user) {
        Users userFound = this.userService.findByUsername(user.getUsername());
        if(userFound == null)
            return null;
        return checkNext(userFound);
    }
}
