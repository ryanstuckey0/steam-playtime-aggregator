package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stucko09.steam_aggregator.model.AppUser;
import com.stucko09.steam_aggregator.model.steam.SteamGame;
import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamGetRecentGamesResponse;

@Service
public class StatsCollectionService {

    @Autowired
    private SteamApiService steamApiService;

    @Autowired
    private GameService gameService;

    public void collectAndSaveInitialPlaytimeStats(AppUser user) {
        SteamGetOwnedGamesResponse ownedGamesResponse = steamApiService
                .getOwnedGames(user.getSteamUserId(), user.getApiKey())
                .getResponse();

        for (SteamGame steamGame : ownedGamesResponse.getGames()) {
            gameService.saveInitialPlaytimeRecord(steamGame, user);
        }
    }

    public void collectAndSaveDailyPlaytimeStats(AppUser user) {
        SteamGetRecentGamesResponse recentGamesResponse = steamApiService
                .getRecentlyPlayedGames(user.getSteamUserId(), user.getApiKey())
                .getResponse();

        for (SteamGame steamGame : recentGamesResponse.getGames()) {
            gameService.saveDailyPlaytimeRecord(steamGame, user);
        }
    }
}
