package com.desafio.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private LocalDate watchedAt;

    @Column(nullable = false)
    private Long movieId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
}
