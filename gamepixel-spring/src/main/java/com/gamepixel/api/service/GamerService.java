package com.gamepixel.api.service;

import java.util.List;

import com.gamepixel.api.exceptions.GamerNotFoundException;
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.GamerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * retrieve all consumers, retrieve specified consumer (via id), add consumer
 * delete consumer (via id)
 */

/**
 * Retrieve By Id To throw custom errors, pass it as a Supplier<String>
 */

@Service
public class GamerService {
    @Autowired
    GamerRepo gamerRepo;

    public List<Gamer> retrieveAllGamers() {
        return this.gamerRepo.findAll();
    }

    public Gamer retrieveById(Integer user_id) {
        return this.gamerRepo.findById(user_id)
                .orElseThrow(() -> new GamerNotFoundException("Cannot find user by their id"));
    }

    public Gamer createGamer(Gamer newGamer) {
        return this.gamerRepo.save(newGamer);
    }

    public void deleteGamer(Integer user_id) {
        this.gamerRepo.deleteById(user_id);
    }
}
