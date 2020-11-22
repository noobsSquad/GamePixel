package com.gamepixel.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.gamepixel.api.dto.RefreshTokenRequest;
import com.gamepixel.api.dto.auth.RegisterRequest;
import com.gamepixel.api.exceptions.UserExistsException;
import com.gamepixel.api.mapper.SignUpMapper;

import com.gamepixel.api.models.auth.User;

import com.gamepixel.api.repository.UserRepository;
import com.gamepixel.api.security.JwtTokenUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    AuthService authService;

    @Mock
    UserRepository userRepository;

    User mockUser;

    @Mock
    RegisterRequest userDto;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    SignUpMapper mapper;

    @Mock
    RefreshTokenRequest refreshTokenRequest;

    @Mock
    RefreshTokenService refreshTokenService;

    @Mock
    JwtTokenUtil jwtTokenUtil;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        userDto = new RegisterRequest();
        userDto.setFirstName("john");
        userDto.setLastName("doe");
        userDto.setEmail("test@test.com");
        userDto.setUsername("qwer");
        userDto.setPassword("password");

        mockUser = SignUpMapper.INSTANCE.mapSignUp(userDto);

        // Auth payload

    }

    @Test
    void testSignUp() {
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(mockUser);
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());

        when(passwordEncoder.encode(anyString())).thenReturn(encryptedPassword);

        User mockUser = SignUpMapper.INSTANCE.mapSignUp(userDto);

        assertNotNull(mockUser);
        verify(passwordEncoder, times(1)).encode(userDto.getPassword());
    }

    @Test
    void testSignUp_throwsGamerExistException() throws UserExistsException {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(mockUser));
        userDto = new RegisterRequest();
        userDto.setFirstName("john");
        userDto.setLastName("doe");
        userDto.setEmail("test@test.com");
        userDto.setUsername("qwer");
        userDto.setPassword("password");

        assertThrows(UserExistsException.class, () -> {
            authService.signUp(userDto);
        });
    }

    @Test
    void testLogin() {

    }

    // refreshing Token test
    @Test
    void testRefreshToken() {

    }

    // get current user test
    @Test
    void testGetCurrentUser() {

    }

}
