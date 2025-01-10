package com.stucko09.steam_aggregator.repository;

import org.springframework.data.repository.CrudRepository;

import com.stucko09.steam_aggregator.model.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    public AppUser findBySteamUserId(Long steamUserId);

    public boolean existsBySteamUserId(Long steamUserId);
}
