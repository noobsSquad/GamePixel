package com.gamepixel.api.controller;

import com.gamepixel.api.dto.RefreshTokenRequest;
import com.gamepixel.api.dto.auth.AuthenticationResponse;
import com.gamepixel.api.dto.auth.LoginRequest;
import com.gamepixel.api.dto.auth.RegisterRequest;
import com.gamepixel.api.exceptions.UserExistsException;
import com.gamepixel.api.service.AuthService;

import com.gamepixel.api.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Most used error -> 409: If user exists
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        try {
            authService.signUp(registerRequest);
        } catch (UserExistsException e) {
            return new ResponseEntity<>("Username Already Exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {

        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully");
    }

    /***
     * 1.put mapping 2. specify the parameters 3. check if user exists 4. stream and
     * map it 5. setter and getter 6. if not found -> return the entity back to the
     * original objected = userRepository.findByUsername(username).orElseThrow(new
     * -> UserNotFoundException); a. stream((par1,par2,par3) ->
     * signUp:map(par1,par2,par3);
     */

}
