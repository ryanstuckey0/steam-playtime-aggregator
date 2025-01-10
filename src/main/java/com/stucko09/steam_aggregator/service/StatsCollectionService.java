package com.stucko09.steam_aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.stucko09.steam_aggregator.model.AppUser;
import com.stucko09.steam_aggregator.model.GamePlaytimeRecord;
import com.stucko09.steam_aggregator.model.GameRecord;
import com.stucko09.steam_aggregator.model.steam.SteamGame;
import com.stucko09.steam_aggregator.model.steam.SteamGetOwnedGamesResponse;
import com.stucko09.steam_aggregator.repository.GamePlaytimeRecordRepository;
import com.stucko09.steam_aggregator.repository.GameRecordRepository;

@Service
public class StatsCollectionService {

    @Autowired
    private SteamApiService steamApiService;

    @Autowired
    private Mapper dozerBeanMapper;

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Autowired
    private GamePlaytimeRecordRepository gamePlaytimeRecordRepository;

    public void collectAndSaveDailyPlaytimeStats(Long steamId, AppUser user) {
        SteamGetOwnedGamesResponse ownedGamesResponse = steamApiService.getOwnedGames(steamId).getResponse();

        for (SteamGame steamGame : ownedGamesResponse.getGames()) {
            if (steamGame.getPlaytimeForever() == 0) continue;

            GameRecord gameRecord = gameRecordRepository.findBySteamAppId(steamGame.getAppid()).orElseGet(() -> {
                GameRecord newGameRecord = dozerBeanMapper.map(steamGame, GameRecord.class);
                return gameRecordRepository.save(newGameRecord);
            });

            GamePlaytimeRecord gamePlaytimeRecord = dozerBeanMapper.map(steamGame, GamePlaytimeRecord.class);
            gamePlaytimeRecord.setGameRecord(gameRecord);
            gamePlaytimeRecord.setAppUser(user);

            gamePlaytimeRecordRepository.save(gamePlaytimeRecord);
        }
    }
}
