package com.stucko09.steam_aggregator.model.steam;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class SteamGetOwnedGamesResponse {
    private String gameCount;
    private List<SteamGame> games;
}
