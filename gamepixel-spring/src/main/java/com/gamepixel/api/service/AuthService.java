package com.gamepixel.api.service;

import com.gamepixel.api.dto.AuthenticationResponse;
import com.gamepixel.api.dto.LoginRequest;
import com.gamepixel.api.dto.RefreshTokenRequest;
import com.gamepixel.api.dto.RegisterRequest;
import com.gamepixel.api.exceptions.UserNotFoundException;
import com.gamepixel.api.repository.UserRepository;
import com.gamepixel.api.security.JwtTokenUtil;
import com.gamepixel.api.exceptions.GamerExistsException;
import com.gamepixel.api.mapper.SignUpMapper;
import com.gamepixel.api.models.User;
import com.gamepixel.api.repository.VerificationTokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//1. add functionally to modify the profile
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository; // to add new gamer or check login gamer
    private final VerificationTokenRepo verificationTokenRepo; // to add token to repo
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil; // to generate token
    private final PasswordEncoder passwordEncoder; // To encode password
    private final UserDetailsService userDetailsService;
    private final RefreshTokenService refreshTokenService;

    public void signUp(RegisterRequest registerRequest) {
//        Optional<User> gamerCheck = userRepository.findByUsername(registerRequest.getUsername()).orElse; -> null
//        if (gamerCheck != null) -> true
//            throw new GamerExistsException("User Already Exists");
        User user = SignUpMapper.INSTANCE.mapSignUp(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            userRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtTokenUtil.generateToken(loadUserDetails(loginRequest.getUsername()));
        AuthenticationResponse auth = new AuthenticationResponse();
        auth.setAuthenticationToken(token);
        auth.setRefreshToken(refreshTokenService.generateRefreshToken().getToken());
        auth.setExpiresAt(Instant.now().plusMillis(jwtTokenUtil.getJwtExpirationInMillis()));
        auth.setUsername(loginRequest.getUsername());
        return auth;
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtTokenUtil.generateToken(loadUserDetails(refreshTokenRequest.getUsername()));
        AuthenticationResponse auth = new AuthenticationResponse();
        auth.setAuthenticationToken(token);
        auth.setRefreshToken(refreshTokenRequest.getRefreshToken());
        auth.setExpiresAt(Instant.now().plusMillis(jwtTokenUtil.getJwtExpirationInMillis()));
        auth.setUsername(refreshTokenRequest.getUsername());
        return auth;
    }
    public UserDetails loadUserDetails(String username){
        return userDetailsService.loadUserByUsername(username);
    }

    public User getCurrentUser(){
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();
        return userRepository.findByUsername(principal.getUsername()).orElseThrow(
                () -> new UserNotFoundException("User not found by username: "
                        + principal.getUsername()));
    }
    /**
     * 1.Login Function
     * 2. SignUp Function
     * 3. Current user Function (Using Security Context) -> JWT Token -> Username
     * 4. generates JWT Token Before expiring if user is loggedIn
     *
     */



}