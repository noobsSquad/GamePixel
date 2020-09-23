package com.gamepixel.api.service;

import com.gamepixel.api.repository.GamerRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class GamerService {
    @Autowired
    GamerRepo gamerRepo;
}
