package com.gamepixel.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.gamepixel.api.dto.auth.RegisterRequest;
import com.gamepixel.api.exceptions.GamerExistsException;
import com.gamepixel.api.mapper.SignUpMapper;

import com.gamepixel.api.models.User;


import com.gamepixel.api.repository.UserRepository;
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

    RegisterRequest userDto;

    PasswordEncoder passwordEncoder;

    @Mock
    SignUpMapper mapper;

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
    }

    @Test
    public void testSignUp() {

        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(mockUser);
        User mockUser = SignUpMapper.INSTANCE.mapSignUp(userDto);
        assertNotNull(mockUser);

    }

    @Test
    public void testSignUp_throwsGamerExistException() throws GamerExistsException {

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(mockUser));
        userDto = new RegisterRequest();
        userDto.setFirstName("john");
        userDto.setLastName("doe");
        userDto.setEmail("test@test.com");
        userDto.setUsername("qwer");
        userDto.setPassword("password");

        assertThrows(GamerExistsException.class, () -> {
            authService.signUp(userDto);
        });
    }

}
