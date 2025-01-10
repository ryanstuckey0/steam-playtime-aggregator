package com.stucko09.steam_aggregator.model;

import com.stucko09.steam_aggregator.util.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GamePlaytimeRecord extends BaseRecordClass {

    @ManyToOne(optional = false)
    private GameRecord gameRecord;

    @ManyToOne(optional = false)
    private AppUser appUser;

    private int playtimeForever;
    private int playtime2Weeks;
    private int playtimeLinuxForever;
    private int playtimeMacForever;
    private int playtimeWindowsForever;
    private int playtimeDeckForever;

    @Enumerated(EnumType.STRING)
    private Constants.PlaytimeRecordType playtimeType;
}
