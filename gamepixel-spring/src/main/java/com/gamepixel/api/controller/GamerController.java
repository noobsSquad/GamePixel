package com.gamepixel.api.controller;

import java.net.URI;
import java.util.List;

import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.service.GamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * POST - add gamer to db GET - retrieving all gamers GET - retrieving specified
 * gamer DELETE - delete consumer from db
 * 
 */

@RestController
@RequestMapping(value = "/gamers")
public class GamerController {
    /**
     * Optimization add Lombok annotation (@AllArgsConstructor) Remove @Autowired
     * since Lombok Remove Constructor remove all requestmapping Use Response Entity
     * for controller
     */
    @Autowired
    GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Gamer>> getAllGamers() {
        return ResponseEntity.status(HttpStatus.OK).body(gamerService.retrieveAllGamers());
    }

    @RequestMapping(value = "/gamers/{user_id}", method = RequestMethod.GET)
    public Gamer getGamerById(@RequestParam(value = "user_id") Integer user_id) {
        return gamerService.retrieveById(user_id);
    }

    @RequestMapping(value = "/gamers/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Gamer addGamer(@RequestBody Gamer newGamer) {
        return gamerService.createGamer(newGamer);
    }

    @RequestMapping(value = "/gamers/{user_id}", method = RequestMethod.DELETE)
    public void deleteGamerFromDb(@RequestParam(value = "user_id") Integer user_id) {
        gamerService.deleteGamer(user_id);
    }

}
