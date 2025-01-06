package com.stucko09.steam_aggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasicAppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
