package com.gamepixel.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.gamepixel.api.dto.RegisterRequest;
import com.gamepixel.api.models.User;

import org.junit.Test;

public class SignUpMapperTest {

    @Test
    public final void shouldMapReqToEntity() {
        RegisterRequest req = new RegisterRequest();
        req.setFirstName("john");
        req.setLastName("doe");
        req.setEmail("test@test.com");
        req.setUsername("jdoe123");
        req.setPassword("test123");

        User gamer = SignUpMapper.INSTANCE.mapSignUp(req);

        assertNotNull(gamer);
        assertEquals(req.getFirstName(), gamer.getFirstName());
        assertEquals(req.getLastName(), gamer.getLastName());
        assertEquals(req.getEmail(), gamer.getEmail());
        assertEquals(req.getUsername(), gamer.getUsername());
        assertEquals(req.getPassword(), gamer.getPassword());

    }

}
