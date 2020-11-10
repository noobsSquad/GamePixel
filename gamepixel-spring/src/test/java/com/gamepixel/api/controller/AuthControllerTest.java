package com.gamepixel.api.controller;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// 
// import java.util.Optional;
// import com.gamepixel.api.models.Gamer;
// import com.gamepixel.api.service.GamerService;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AuthControllerTest {
    // @InjectMocks
    // AuthController gamerController;
    //
    // @Mock
    // GamerService gamerService;
    //
    // @Test
    // public void addGamerTest() {
    // MockHttpServletRequest req = new MockHttpServletRequest();
    // RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
    //
    // when(gamerService.createGamer(any(Gamer.class))).thenReturn(true);
    //
    // Gamer testGamer = new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21",
    // "qwerty12345");
    // ResponseEntity<Gamer> responseEntity = gamerController.addGamer(testGamer);
    //
    // // assertThat(responseEntity.getStatusCode(), 201);
    //
    // // assertEquals(responseEntity.getHeaders().getLocation().getPath(), "/1");
    // }
    //
    // @Test
    // public void getGamerTest() {
    //
    // }
    //
    // @Test
    // public void retrieveAllGamersTest() {
    //
    // }
    //
    // @Test
    // public void deleteGamerTest() {
    //
    // }

    AuthController gamerController;

    // @Test
    /*
     * public void addGamerTest() { MockHttpServletRequest req = new
     * MockHttpServletRequest(); RequestContextHolder.setRequestAttributes(new
     * ServletRequestAttributes(req));
     * 
     * when(gamerService.createGamer(any(Gamer.class))).thenReturn(true);
     * 
     * Gamer testGamer = new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21",
     * "qwerty12345"); ResponseEntity<Object> responseEntity =
     * gamerController.addGamer(testGamer);
     * 
     * // assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201); //
     * assertEquals(responseEntity.getHeaders().getLocation().getPath(), "/1"); }
     */

    @Test
    public void getGamerTest() {

    }

    @Test
    public void retrieveAllGamersTest() {

    }

    @Test
    public void deleteGamerTest() {

    }

}
