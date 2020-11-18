package com.gamepixel.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private final String jwtToken;
    //private final Instant createdOn;
    //private final Instant ExpiredAt;
    //private final String username;

}
