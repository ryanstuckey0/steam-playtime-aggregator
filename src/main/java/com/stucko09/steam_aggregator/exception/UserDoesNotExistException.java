package com.stucko09.steam_aggregator.exception;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(String username) {
        super("User with username " + username + " does not exist.");
    }

    public UserDoesNotExistException(long steamId) {
        super("User with steamId " + steamId + " does not exist.");
    }
}
