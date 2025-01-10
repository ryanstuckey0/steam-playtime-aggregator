package com.stucko09.steam_aggregator.repository;

import org.springframework.data.repository.CrudRepository;

import com.stucko09.steam_aggregator.model.GamePlaytimeRecord;

public interface GamePlaytimeRecordRepository extends CrudRepository<GamePlaytimeRecord, Long> {
    
}
