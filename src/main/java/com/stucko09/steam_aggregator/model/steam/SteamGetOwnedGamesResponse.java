package com.stucko09.steam_aggregator.model.steam;

import lombok.Data;

@Data
public class SteamGetOwnedGamesResponse {
    private String gameCount;
    private SteamGame[] games;
}
