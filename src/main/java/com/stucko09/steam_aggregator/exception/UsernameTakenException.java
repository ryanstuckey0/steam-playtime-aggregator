package com.stucko09.steam_aggregator.exception;

public class UsernameTakenException extends Exception {
    public UsernameTakenException(String username) {
        super("Username " + username + " is already taken.");
    }
}
