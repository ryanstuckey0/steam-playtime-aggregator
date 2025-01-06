package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;

@Service
public class SteamApiService {
    private static final String GET_OWNED_GAMES_REQUEST_PATH = "/IPlayerService/GetOwnedGames/v0001/?key=%s&steamid=%s&format=json";

    @Value("${steam.hostname}")
    private String steamApiHostname;

    @Value("${steam.api-key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public SteamResponse<SteamGetOwnedGamesResponse> getOwnedGames(String steamId) {
        ResponseEntity<SteamResponse<SteamGetOwnedGamesResponse>> response = restTemplate.exchange(
                steamApiHostname + String.format(GET_OWNED_GAMES_REQUEST_PATH, apiKey, steamId),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<SteamResponse<SteamGetOwnedGamesResponse>>() {
                });
        return response.getBody();
    }
}
