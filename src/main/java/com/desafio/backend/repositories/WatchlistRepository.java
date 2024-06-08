package com.desafio.backend.repositories;

import com.desafio.backend.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long>{
    List<Watchlist> findAllByUserId(UUID id);
    Watchlist findByMovieIdAndUserId(Long movieId, UUID userId);
}
