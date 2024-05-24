package com.desafio.backend.middlewares.auth;

import com.desafio.backend.entities.Users;

public class PasswordMiddleware extends Middleware{
    private final Users originalUser;

    public PasswordMiddleware(Users user){
        this.originalUser = user;
    }
    @Override
    public Users check(Users user) {
        if(user.getPassword().equals(originalUser.getPassword()))
            return checkNext(user);
        return null;
    }
}
