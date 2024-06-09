package com.desafio.backend.repositories;

import com.desafio.backend.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long>{
    List<Watchlist> findAllByUserId(Long id);
    Watchlist findByMovieIdAndUserId(Long movieId, Long userId);
    List<Watchlist> findAllByMovieId(Long movieId);
}
