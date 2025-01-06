package com.stucko09.steam_aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;
import com.stucko09.steam_aggregator.service.SteamApiService;

@RestController
public class SimpleApiController {
    @Autowired
    private SteamApiService steamApiService;

    @GetMapping("/getOwnedGames/{steamId}")
    public SteamResponse<SteamGetOwnedGamesResponse> getMethodName(@PathVariable String steamId) {
        return steamApiService.getOwnedGames(steamId);
    }
}
