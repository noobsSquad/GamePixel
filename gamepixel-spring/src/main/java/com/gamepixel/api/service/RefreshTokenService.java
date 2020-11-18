package com.gamepixel.api.service;

import com.gamepixel.api.exceptions.JwtTokenException;
import com.gamepixel.api.models.RefreshToken;
import com.gamepixel.api.repository.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    /***
     * Method used to generate a new refresh token
     * @return RefreshToken
     */
    public RefreshToken generateRefreshToken(){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());
        return refreshTokenRepository.save(refreshToken);
    }

    /***
     * Method used to validate a RefreshToken, throws exception when token not found
     * @param token
     */
     public void validateRefreshToken(String token){
        refreshTokenRepository.findByToken(token).orElseThrow(() -> new JwtTokenException("Refresh Token Not Found!"));
    }

    /***
     * Method used to delete a Token from the database
     * @param token
     */
    public void deleteRefreshToken(String token){
        refreshTokenRepository.deleteByToken(token);
    }
}
