package com.gamepixel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.gamepixel.api.models.auth.VerificationToken;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
