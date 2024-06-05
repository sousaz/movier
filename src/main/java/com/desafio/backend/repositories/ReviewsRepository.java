package com.desafio.backend.repositories;

import com.desafio.backend.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
    Reviews findByMovieIdAndUserId(Long movieId, UUID userId);
    List<Reviews> findByMovieId(Long movieId);
}
