package com.desafio.backend.repositories;

import com.desafio.backend.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    Reviews findByMovieIdAndUserId(Long movieId, Long userId);
    List<Reviews> findByMovieId(Long movieId);

    List<Reviews> findByUserIdAndWatchedAtIsNotNull(Long userId);
}
