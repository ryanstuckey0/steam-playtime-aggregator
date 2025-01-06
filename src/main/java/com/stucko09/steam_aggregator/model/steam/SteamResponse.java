package com.stucko09.steam_aggregator.model.steam;

import lombok.Data;

@Data
public class SteamResponse<T> {
    private T response;
}
