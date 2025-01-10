package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.model.steam.SteamResponse;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Service
public class SteamApiService {
    private static final String GET_OWNED_GAMES_REQUEST_PATH = "/IPlayerService/GetOwnedGames/v0001/?key=%s&steamid=%s&format=json&include_appinfo=1";

    @Value("${steam.hostname}")
    private String steamApiHostname;

    @Value("${steam.api-key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public SteamResponse<SteamGetOwnedGamesResponse> getOwnedGames(Long steamId) {
        RequestEntity<Void> requestEntity = RequestEntity
                .get(steamApiHostname + String.format(GET_OWNED_GAMES_REQUEST_PATH, apiKey, steamId))
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<SteamResponse<SteamGetOwnedGamesResponse>> response = restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<SteamResponse<SteamGetOwnedGamesResponse>>() {
                });

        return response.getBody();
    }
}
