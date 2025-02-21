package com.stucko09.steam_aggregator.model.rest;

import com.github.dozermapper.core.Mapping;

import lombok.Data;

@Data
public class UserOwnedGamesResponse {
    @Mapping("gameRecord.name")
    private String gameName;

    @Mapping("gameRecord.steamAppId")
    private String steamAppId;

    @Mapping("gameRecord.id")
    private String gameId;

    @Mapping("appUser.username")
    private String username;

    @Mapping("appUser.id")
    private String userId;
}
