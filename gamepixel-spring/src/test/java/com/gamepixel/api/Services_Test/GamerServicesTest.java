package com.gamepixel.api.Services_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepo;
import com.gamepixel.api.service.GamerService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GamerServicesTest {
    /**
     * Creating mock objects
     * 
     * GamerRepo injects into GamerService
     * 
     * @Mock -> @InjectMocks
     */
    @InjectMocks
    private GamerService gamerService;

    @Mock
    private GamerRepo gamerRepo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Testing Service Layer
     */
    @Test
    public void findAllGamersTest() {
        List<Gamer> gamers = new ArrayList<Gamer>();
        Gamer gamerA = new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21", "qwerty12345");
        Gamer gamerB = new Gamer(2, "Joe", "Mom", "joemom@mail", "jmom21", "ytrewq12345");

        gamers.add(gamerA);
        gamers.add(gamerB);

        when(gamerRepo.findAll()).thenReturn(gamers);

        List<Gamer> gamerList = gamerService.retrieveAllGamers();

        assertEquals(2, gamerList.size());
    }

    @Test
    public void getGamerByIdTest() {
        when(gamerRepo.findById(1))
                .thenReturn(Optional.of(new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21", "qwerty12345")));

        Gamer catchGamer = gamerService.retrieveById(1);

        assertEquals("John", catchGamer.getFirstName());
        assertEquals("Doe", catchGamer.getLastName());
        assertEquals("jdoe123@mail.com", catchGamer.getEmail());
        assertEquals("jdoe21", catchGamer.getUserName());
        assertEquals("qwerty12345", catchGamer.getPassword());

    }

    @Test
    public void createGamerTest() {
        Gamer gamer = new Gamer(1, "John", "Doe", "jdoe123@mail.com", "jdoe21", "qwerty12345");

        gamerService.createGamer(gamer);

        verify(gamerRepo, times(1)).save(gamer);
    }

}
