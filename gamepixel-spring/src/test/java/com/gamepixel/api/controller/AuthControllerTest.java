package com.gamepixel.api.controller;

import com.gamepixel.api.service.AuthService;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// 
// import java.util.Optional;
// import com.gamepixel.api.models.Gamer;
// import com.gamepixel.api.service.GamerService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AuthControllerTest {

    @InjectMocks
    AuthController authController;

    @Mock
    AuthService authService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testSignUp() {

    }

    @Test
    public void retrieveAllGamersTest() {

    }

    @Test
    public void deleteGamerTest() {

    }

}
