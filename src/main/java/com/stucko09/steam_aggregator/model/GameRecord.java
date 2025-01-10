package com.stucko09.steam_aggregator.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.dozermapper.core.Mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class GameRecord {
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

    @Mapping("appid")
    private Long steamAppId;

    private String name;
}
