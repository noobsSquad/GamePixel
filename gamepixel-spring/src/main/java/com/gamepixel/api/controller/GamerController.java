package com.gamepixel.api.controller;

import com.gamepixel.api.service.GamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GamerController {

    @Autowired
    GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }
}
