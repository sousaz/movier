package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.WatchlistRequestCreateDTO;
import com.desafio.backend.dto.WatchlistResponseDTO;
import com.desafio.backend.entities.Users;
import com.desafio.backend.entities.Watchlist;
import org.springframework.stereotype.Component;

@Component
public class WatchlistMapper {
    public Watchlist toEntity(WatchlistRequestCreateDTO watchlist, Users user) {
        Watchlist watchlistEntity = new Watchlist();
        watchlistEntity.setMovieId(watchlist.movieId());
        watchlistEntity.setPoster_Path(watchlist.poster_path());
        watchlistEntity.setUser(user);
        return watchlistEntity;
    }

    public WatchlistResponseDTO toDTO(Watchlist watchlist) {
        return new WatchlistResponseDTO(watchlist.getMovieId(), watchlist.getUser().getId(), watchlist.getPoster_Path());
    }
}
