package com.gamepixel.api.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Login Payload for authentication

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    public String username;
    public String password;
}
