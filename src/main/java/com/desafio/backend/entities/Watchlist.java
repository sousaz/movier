package com.desafio.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private Long movieId;
    @Column(nullable = false)
    private String poster_Path;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;
}
