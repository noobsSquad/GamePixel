package com.gamepixel.api.controller;

import java.util.List;

import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.service.GamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * POST - add gamer to db GET - retrieving all gamers GET - retrieving specified
 * gamer DELETE - delete consumer from db
 * 
 */

@RestController
@RequestMapping(value = "/gamers")
public class AuthController {
    /**
     * Optimization add Lombok annotation (@AllArgsConstructor) Remove @Autowired
     * since Lombok Remove Constructor remove all requestmapping Use Response Entity
     * for controller
     */
    @Autowired
    GamerService gamerService;

    public AuthController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Gamer>> getAllGamers() {
        return ResponseEntity.status(HttpStatus.OK).body(gamerService.retrieveAllGamers());
    }

    @GetMapping(value = "/gamers/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Gamer> getGamerById(@RequestParam(value = "user_id") Integer user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(gamerService.retrieveById(user_id));
    }

    @PostMapping(value = "/gamers/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Gamer> addGamer(@RequestBody Gamer newGamer) {
        gamerService.createGamer(newGamer);
        return new ResponseEntity<Gamer>(newGamer, HttpStatus.OK);
    }

    @DeleteMapping(value = "gamers/{user_id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteGamerById(@RequestParam(value = "user_id") Integer user_id) {
        gamerService.deleteGamer(user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
