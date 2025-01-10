package com.stucko09.steam_aggregator.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class GamePlaytimeRecord {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    private ZonedDateTime creationTimestamp;

    @Setter(AccessLevel.NONE)
    @UpdateTimestamp
    private ZonedDateTime updateTimestamp;

    @ManyToOne
    private GameRecord gameRecord;

    @ManyToOne
    private AppUser appUser;

    private int playtimeForever;
    private int playtime2Weeks;
    private int playtimeLinuxForever;
    private int playtimeMacForever;
    private int playtimeWindowsForever;
    private int playtimeDeckForever;
}
