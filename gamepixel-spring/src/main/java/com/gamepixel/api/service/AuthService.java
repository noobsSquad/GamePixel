package com.gamepixel.api.service;

import com.gamepixel.api.dto.LoginRequest;
import com.gamepixel.api.dto.JwtResponse;
import com.gamepixel.api.security.JwtTokenUtil;
import com.gamepixel.api.dto.RegisterRequest;
import com.gamepixel.api.exceptions.GamerExistsException;
import com.gamepixel.api.mapper.SignUpMapper;
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepo;
import com.gamepixel.api.repository.VerificationTokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//1. add functionally to modify the profile
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
        private final GamerRepo gamerRepo; // to add new gamer or check login gamer
        private final VerificationTokenRepo verificationTokenRepo; // to add token to repo
        private final AuthenticationManager authenticationManager;
        private final JwtTokenUtil jwtTokenUtil; // to generate token
        private final PasswordEncoder passwordEncoder; // To encode password
        private final UserDetailsService userDetailsService;

        public void signUp(RegisterRequest registerRequest) {
                // check if gamer exists

                Optional<Gamer> gamerCheck = gamerRepo.findByUsername(registerRequest.getUsername());
                if (gamerCheck != null) {
                        throw new GamerExistsException("Gamer Already Exists");
                }

                Gamer gamer = SignUpMapper.INSTANCE.mapSignUp(registerRequest);
                gamerRepo.save(gamer);
                // Initial Creation Time will have first_Name, last_Name empty ATM
                // Plan should be to implement that idea either at
                // a. (Sign-up)
                // b. modified under profile modification (profile.html)
                // String token = generateVerificationToken(gamer);

        }

        public ResponseEntity<?> login(LoginRequest loginRequest) {
                Authentication authenticate = authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                                                loginRequest.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

                // String token = jwtTokenUtil.generateToken(authenticate);
                String token = jwtTokenUtil.generateToken(userDetails);
                return ResponseEntity.ok(new JwtResponse(token));
                // return ResponseEntity.ok(AuthenticationResponse.builder()
                // .authenticationToken(token)
                // .refreshToken()
                // );
                // return Authe
        }

        // public String generateVerificationToken(Gamer gamer){
        // String token = UUID.randomUUID().toString();
        // VerificationToken verificationToken = new VerificationToken();
        // verificationToken.setToken(token);
        // verificationToken.setGamer(gamer);
        // VerificationTokenRepo.save(verificationToken);
        // }

}
