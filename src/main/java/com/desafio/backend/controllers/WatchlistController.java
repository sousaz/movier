package com.desafio.backend.controllers;

import com.desafio.backend.dto.WatchlistRequestCreateDTO;
import com.desafio.backend.dto.WatchlistResponseDTO;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.services.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping
    public void addWatchlist(@RequestBody WatchlistRequestCreateDTO watchlist) {
        this.watchlistService.addWatchlist(watchlist);
    }

    @GetMapping("/{id}")
    public List<WatchlistResponseDTO> getWatchlist(@PathVariable UUID id) {
        return this.watchlistService.listWatchlist(id);
    }

}
