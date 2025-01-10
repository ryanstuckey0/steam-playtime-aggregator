package com.stucko09.steam_aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;
import com.stucko09.steam_aggregator.service.StatsCollectionService;
import com.stucko09.steam_aggregator.service.SteamApiService;

@RestController
public class SimpleApiController {
    @Autowired
    private SteamApiService steamApiService;

    @Autowired
    private StatsCollectionService statsCollectionService;

    @GetMapping("/getOwnedGames/{steamId}")
    public SteamResponse<SteamGetOwnedGamesResponse> getOwnedGames(@PathVariable Long steamId) {
        return steamApiService.getOwnedGames(steamId);
    }

    @GetMapping("/saveDailyPlaytime/{steamId}")
    public void updateOwnedGames(@PathVariable Long steamId) {
        statsCollectionService.collectAndSaveDailyPlaytimeStats(steamId);
    }
}
