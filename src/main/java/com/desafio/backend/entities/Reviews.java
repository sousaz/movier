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

    @Column(nullable = true)
    private String text;

    @Column(nullable = true)
    private Double rating;

    @Column(nullable = false)
    private LocalDate watchedAt;

    @Column(nullable = false)
    private Long movieId;

    @Column(nullable = false)
    private String poster_Path;

    @Column(nullable = false)
    private String release_date;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;
}
