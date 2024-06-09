package com.desafio.backend.Observers;

import com.desafio.backend.entities.Users;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.interfaces.Observer;
import com.desafio.backend.services.EmailService;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter
public class WatchlistObserver implements Observer {
    @Autowired
    private EmailService emailService;
    private String title;
    private Users user;

    @Override
    public void update(WatchlistObserver movie) {
        this.emailService.sendSimpleEmail(this.user.getEmail(), this.title);
    }
}
