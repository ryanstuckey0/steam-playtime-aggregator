package com.stucko09.steam_aggregator.repository;

import org.springframework.data.repository.CrudRepository;

import com.stucko09.steam_aggregator.model.AppUser;
import com.stucko09.steam_aggregator.model.GamePlaytimeRecord;
import com.stucko09.steam_aggregator.model.GameRecord;

public interface GamePlaytimeRecordRepository extends CrudRepository<GamePlaytimeRecord, Long> {
    public boolean existsByAppUser(AppUser appUser);
    public boolean existsByGameRecord(GameRecord gameRecord);
}
