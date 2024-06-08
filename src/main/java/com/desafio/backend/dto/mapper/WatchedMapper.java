package com.desafio.backend.dto.mapper;

import com.desafio.backend.dto.WatchedDTO;
import com.desafio.backend.entities.Reviews;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WatchedMapper {
    public WatchedDTO toDTO(Reviews reviews, boolean favorited){
        return new WatchedDTO(reviews.getUser().getId(), reviews.getMovieId(), reviews.getPoster_Path(), reviews.getWatchedAt(), reviews.getRelease_date(), reviews.getRating(), favorited);
    }
}
