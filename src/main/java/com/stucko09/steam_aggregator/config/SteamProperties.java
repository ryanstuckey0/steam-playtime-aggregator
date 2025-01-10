package com.stucko09.steam_aggregator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "steam")
public class SteamProperties {
    private String hostname;
    private String apiKey;
}
