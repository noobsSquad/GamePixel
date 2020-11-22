package com.gamepixel.api.exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String msg) {
        super(msg);
    }

}
