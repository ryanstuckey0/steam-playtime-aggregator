package com.stucko09.steam_aggregator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends BaseRecordClass {
    @Column(unique = true, nullable = false)
    private Long steamUserId;

    @Transient
    private String apiKey;

    public AppUser(Long steamUserId) {
        this.steamUserId = steamUserId;
    }
}
