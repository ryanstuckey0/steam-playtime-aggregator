package com.stucko09.steam_aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.stucko09.steam_aggregator.model.AppUser;
import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;
import com.stucko09.steam_aggregator.service.StatsCollectionService;
import com.stucko09.steam_aggregator.service.SteamApiService;
import com.stucko09.steam_aggregator.service.UserService;


@RestController
public class SimpleApiController {
    @Autowired
    private SteamApiService steamApiService;

    @Autowired
    private StatsCollectionService statsCollectionService;

    @Autowired
    private UserService userService;

    @GetMapping("/getOwnedGames/{steamId}")
    public SteamResponse<SteamGetOwnedGamesResponse> getOwnedGames(@RequestHeader String apiKey, @PathVariable Long steamId) {
        return steamApiService.getOwnedGames(steamId, apiKey);
    }

    @GetMapping("/saveInitialPlaytime/{steamId}")
    public void saveInitialPlaytime(@RequestHeader String apiKey, @PathVariable Long steamId) {
        AppUser user = userService.retrieveUserOrThrowException(steamId);
        user.setApiKey(apiKey);
        statsCollectionService.collectAndSaveInitialPlaytimeStats(user);
    }

    @GetMapping("/saveDailyPlaytime/{steamId}")
    public void saveDailyPlaytime(@RequestHeader String apiKey, @PathVariable Long steamId) {
        AppUser user = userService.retrieveUserOrThrowException(steamId);
        user.setApiKey(apiKey);
        statsCollectionService.collectAndSaveDailyPlaytimeStats(user);
    }
    

    @GetMapping("/registerUser/{steamId}")
    public void registerUser(@RequestHeader String apiKey, @PathVariable Long steamId) {
        userService.registerUserAndSaveInitialPlaytime(steamId, apiKey);
    }
}
