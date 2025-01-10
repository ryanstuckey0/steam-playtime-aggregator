package com.stucko09.steam_aggregator.repository;

import org.springframework.data.repository.CrudRepository;

import com.stucko09.steam_aggregator.model.GameRecord;

public interface GameRecordRepository extends CrudRepository<GameRecord, Long> {
    public boolean existsBySteamAppId(Long steamAppId);
}
