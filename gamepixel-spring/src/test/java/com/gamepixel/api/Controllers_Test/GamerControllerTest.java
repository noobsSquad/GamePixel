package com.gamepixel.api.Controllers_Test;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// 
// import java.util.Optional;

import com.gamepixel.api.controller.GamerController;
// import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepo;
// import com.gamepixel.api.service.GamerService;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GamerControllerTest {

    @InjectMocks
    GamerController gamerController;

    @Mock
    GamerRepo gamerRepo;

    @Test
    public void addGamerTest() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));

        // when(gamerRepo.save(entity))).thenReturn(true);
    }

}
