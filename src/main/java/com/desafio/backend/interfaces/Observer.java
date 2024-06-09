package com.desafio.backend.interfaces;

import com.desafio.backend.Observers.WatchlistObserver;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.services.EmailService;

public interface Observer {
    void update(WatchlistObserver movie);
}
