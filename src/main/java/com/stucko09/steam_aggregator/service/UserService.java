package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stucko09.steam_aggregator.model.AppUser;
import com.stucko09.steam_aggregator.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatsCollectionService statsCollectionService;

    public AppUser registerUserAndSaveInitialPlaytime(Long steamId, String apiKey) {
        AppUser user = registerUser(steamId);
        user.setApiKey(apiKey);
        statsCollectionService.collectAndSaveInitialPlaytimeStats(user);
        return user;
    }

    public AppUser retrieveUserOrThrowException(Long steamId) {
        AppUser user = userRepository.findBySteamUserId(steamId);
        if (user == null)
            throw new RuntimeException("User with steamId " + steamId + " is not registered.");
        return user;
    }

    public boolean userIsRegistered(Long steamId) {
        return userRepository.existsBySteamUserId(steamId);
    }

    private AppUser registerUser(Long steamId) {
        return userRepository.save(new AppUser(steamId));
    }
}
