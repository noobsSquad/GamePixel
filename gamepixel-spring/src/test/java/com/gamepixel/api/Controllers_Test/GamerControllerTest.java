package com.gamepixel.api.Controllers_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// 
// import java.util.Optional;

import com.gamepixel.api.controller.AuthController;
import com.gamepixel.api.models.Gamer;
// import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepo;
// import com.gamepixel.api.service.GamerService;
import com.gamepixel.api.service.GamerService;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GamerControllerTest {
//
//    @InjectMocks
//    AuthController gamerController;
//
//    @Mock
//    GamerService gamerService;
//
//    @Test
//    public void addGamerTest() {
//        MockHttpServletRequest req = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
//
//        when(gamerService.createGamer(any(Gamer.class))).thenReturn(true);
//
//        Gamer testGamer = new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21", "qwerty12345");
//        ResponseEntity<Gamer> responseEntity = gamerController.addGamer(testGamer);
//
//        // assertThat(responseEntity.getStatusCode(), 201);
//
//        // assertEquals(responseEntity.getHeaders().getLocation().getPath(), "/1");
//    }
//
//    @Test
//    public void getGamerTest() {
//
//    }
//
//    @Test
//    public void retrieveAllGamersTest() {
//
//    }
//
//    @Test
//    public void deleteGamerTest() {
//
//    }

}
