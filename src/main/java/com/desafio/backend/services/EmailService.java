package com.desafio.backend.services;

import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.interfaces.Observer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleEmail(String to, String title) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("New review for a movie on your watchlist");
        message.setText("There is a new review for the movie " + title + " on your watchlist");
        this.mailSender.send(message);
    }
}
