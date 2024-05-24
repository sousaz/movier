package com.desafio.backend.middlewares.auth;

import com.desafio.backend.entities.Users;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Users check(Users user);

    protected Users checkNext(Users user) {
        if (next == null) {
            return user;
        }
        return next.check(user);
    }


}
