package com.desafio.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private LocalDateTime watched_at;

    @Column(nullable = false)
    private Long movie_id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;
}
