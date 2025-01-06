package com.stucko09.steam_aggregator.model.steam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class SteamGame {
    private String appId;
    private String name;
    private String playtime2Weeks;
    private String playtimeForever;
}
