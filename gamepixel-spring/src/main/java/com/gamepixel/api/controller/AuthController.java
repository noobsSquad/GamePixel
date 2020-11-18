package com.gamepixel.api.controller;

import com.gamepixel.api.dto.AuthenticationResponse;
import com.gamepixel.api.dto.RefreshTokenRequest;
import com.gamepixel.api.dto.LoginRequest;
import com.gamepixel.api.dto.RegisterRequest;
import com.gamepixel.api.service.AuthService;

import com.gamepixel.api.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/**
 * POST - add gamer to db GET - retrieving all gamers GET - retrieving specified
 * gamer DELETE - delete consumer from db
 * 
 */

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {

        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully");
    }

    /***
     * 1.put mapping
     * 2. specify the parameters
     * 3. check if user exists
     * 4. stream and map it
     * 5. setter and getter
     * 6. if not found -> return the entity back to the original
     * objected = userRepository.findByUsername(username).orElseThrow(new -> UserNotFoundException);
     * a. stream((par1,par2,par3) -> signUp:map(par1,par2,par3);
     */

}
