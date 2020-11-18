package com.gamepixel.api.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String authenticationToken; //BEARER TOKEN
    private String username; // USERNAME
    private String refreshToken; // to be used with JWT
    private Instant expiresAt; //expires at
}
