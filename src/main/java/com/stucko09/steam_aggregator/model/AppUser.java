package com.stucko09.steam_aggregator.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class AppUser {
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

    @Column(unique = true)
    private Long steamUserId;

    public AppUser(Long steamUserId) {
        this.steamUserId = steamUserId;
    }
}
