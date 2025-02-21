package com.stucko09.steam_aggregator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsernameTakenException extends Exception {
    public UsernameTakenException(String username) {
        super("Username " + username + " is already taken.");
    }
}
