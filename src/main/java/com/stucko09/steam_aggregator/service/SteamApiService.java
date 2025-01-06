package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stucko09.steam_aggregator.model.steam.GetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;

@Service
public class SteamApiService {
    private static final String API_KEY = "5C80183AD39463FB07B80BE152653C6F";
    private static final String STEAM_API_HOSTNAME = "http://api.steampowered.com";
    private static final String GET_OWNED_GAMES_REQUEST_PATH = "/IPlayerService/GetOwnedGames/v0001/?key=%s&steamid=%s&format=json";

    @Autowired
    private RestTemplate restTemplate;

    public SteamResponse<GetOwnedGamesResponse> getOwnedGames(String steamId) {
        ResponseEntity<SteamResponse<GetOwnedGamesResponse>> response = restTemplate.exchange(
                STEAM_API_HOSTNAME + String.format(GET_OWNED_GAMES_REQUEST_PATH, API_KEY, steamId),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<SteamResponse<GetOwnedGamesResponse>>() {
                });
        return response.getBody();
    }
}
