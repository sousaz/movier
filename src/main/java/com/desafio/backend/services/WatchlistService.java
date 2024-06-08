package com.desafio.backend.services;

import com.desafio.backend.dto.WatchlistRequestCreateDTO;
import com.desafio.backend.dto.WatchlistResponseDTO;
import com.desafio.backend.dto.mapper.WatchlistMapper;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.repositories.ReviewsRepository;
import com.desafio.backend.repositories.UserRepository;
import com.desafio.backend.repositories.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final UserRepository userRepository;
    private final WatchlistMapper watchlistMapper;
    private final ReviewsRepository reviewsRepository;

    public WatchlistService(WatchlistRepository watchlistRepository, UserRepository userRepository, WatchlistMapper watchlistMapper, ReviewsRepository reviewsRepository){
        this.watchlistRepository = watchlistRepository;
        this.userRepository = userRepository;
        this.watchlistMapper = watchlistMapper;
        this.reviewsRepository = reviewsRepository;
    }

    public Watchlist addWatchlist(WatchlistRequestCreateDTO watchlist) {
        Users user = this.userRepository.findById(watchlist.userId());
        Watchlist foundWatchilist = this.watchlistRepository.findByMovieIdAndUserId(watchlist.movieId(),user.getId());
        if(foundWatchilist != null) return null;
        return this.watchlistRepository.save(this.watchlistMapper.toEntity(watchlist, user));
    }

    public List<WatchlistResponseDTO> listWatchlist(UUID id) {
        List<Watchlist> watchlist = this.watchlistRepository.findAllByUserId(id);
        List<WatchlistResponseDTO> watchlistResponseDTO = new ArrayList<>();
        watchlist.forEach(watch -> {
            Reviews review = this.reviewsRepository.findByMovieIdAndUserId(watch.getMovieId(), watch.getUser().getId());
            if(review != null) return;
            watchlistResponseDTO.add(this.watchlistMapper.toDTO(watch));
        });
        return watchlistResponseDTO;
    }
}
