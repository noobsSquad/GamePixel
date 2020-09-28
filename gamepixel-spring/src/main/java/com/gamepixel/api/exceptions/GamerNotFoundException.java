package com.gamepixel.api.exceptions;

//Serial id

public class GamerNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Whenever changing project version, change the serialUID
     * 
     */
    // private static final long serialVersionUID = 2404001185162478098L;

    public GamerNotFoundException(String msg) {
        super(msg);
    }
}
