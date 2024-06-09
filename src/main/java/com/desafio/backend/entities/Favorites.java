package com.desafio.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long movieId;
    @Column(nullable = false)
    private String poster_Path;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;
}
