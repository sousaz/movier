package com.desafio.backend.services;

import com.desafio.backend.dto.WatchlistRequestCreateDTO;
import com.desafio.backend.dto.WatchlistResponseDTO;
import com.desafio.backend.dto.mapper.WatchlistMapper;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.repositories.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

@Service
public class WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final UserService userService;
    private final WatchlistMapper watchlistMapper;
    private final ReviewService reviewsService;

    public WatchlistService(WatchlistRepository watchlistRepository, UserService userService, WatchlistMapper watchlistMapper, ReviewService reviewsService){
        this.watchlistRepository = watchlistRepository;
        this.userService = userService;
        this.watchlistMapper = watchlistMapper;
        this.reviewsService = reviewsService;
    }

    public Watchlist addWatchlist(WatchlistRequestCreateDTO watchlist) {
        Users user = this.userService.findById(watchlist.userId());
        Watchlist foundWatchilist = this.watchlistRepository.findByMovieIdAndUserId(watchlist.movieId(),user.getId());
        if(foundWatchilist != null) return null;
        return this.watchlistRepository.save(this.watchlistMapper.toEntity(watchlist, user));
    }

    public List<WatchlistResponseDTO> listWatchlist(Long id) {
        List<Watchlist> watchlist = this.watchlistRepository.findAllByUserId(id);
        List<WatchlistResponseDTO> watchlistResponseDTO = new ArrayList<>();
        watchlist.forEach(watch -> {
            Reviews review = this.reviewsService.findByMovieIdAndUserId(watch.getMovieId(), watch.getUser().getId());
            if(review != null) return;
            watchlistResponseDTO.add(this.watchlistMapper.toDTO(watch));
        });
        return watchlistResponseDTO;
    }

    public List<Watchlist> findWatchlistByMovieId(Long movieId){
        return this.watchlistRepository.findAllByMovieId(movieId);
    }
}
