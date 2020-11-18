package com.gamepixel.api.exceptions;

public class JwtTokenException extends RuntimeException{
    public JwtTokenException(String msg){
        super(msg);
    }
}
