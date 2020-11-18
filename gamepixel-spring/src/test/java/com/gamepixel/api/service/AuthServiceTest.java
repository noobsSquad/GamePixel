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
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepository;

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
    GamerRepository gamerRepository;

    Gamer mockGamer;

    RegisterRequest gamerDto;

    PasswordEncoder passwordEncoder;

    @Mock
    SignUpMapper mapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        gamerDto = new RegisterRequest();
        gamerDto.setFirstName("john");
        gamerDto.setLastName("doe");
        gamerDto.setEmail("test@test.com");
        gamerDto.setUsername("qwer");
        gamerDto.setPassword("password");

        mockGamer = SignUpMapper.INSTANCE.mapSignUp(gamerDto);
    }

    @Test
    public void testSignUp() {
        when(gamerRepository.findByUsername(anyString())).thenReturn(null);
        when(gamerRepository.save(any(Gamer.class))).thenReturn(mockGamer);

        Gamer mockGamer = SignUpMapper.INSTANCE.mapSignUp(gamerDto);
        assertNotNull(mockGamer);

    }

    @Test
    public void testSignUp_throwsGamerExistException() throws GamerExistsException {

        when(gamerRepository.findByUsername(anyString())).thenReturn(Optional.of(mockGamer));

        gamerDto = new RegisterRequest();
        gamerDto.setFirstName("john");
        gamerDto.setLastName("doe");
        gamerDto.setEmail("test@test.com");
        gamerDto.setUsername("qwer");
        gamerDto.setPassword("password");

        assertThrows(GamerExistsException.class, () -> {
            authService.signUp(gamerDto);
        });
    }

}
