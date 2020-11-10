package com.gamepixel.api.controller;

import com.gamepixel.api.security.JwtTokenUtil;
import com.gamepixel.api.dto.LoginRequest;
import com.gamepixel.api.dto.RegisterRequest;
import com.gamepixel.api.service.AuthService;

import com.gamepixel.api.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * POST - add gamer to db GET - retrieving all gamers GET - retrieving specified
 * gamer DELETE - delete consumer from db
 * 
 */

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {
    /**
     * Optimization add Lombok annotation (@AllArgsConstructor) Remove @Autowired
     * since Lombok Remove Constructor remove all requestmapping Use Response Entity
     * for controller
     */
    // private final GamerService gamerService;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        return authService.login(loginRequest);
        /*
         * @PostMapping(value = "/gamers/add", consumes = {
         * MediaType.APPLICATION_JSON_VALUE }, produces = {
         * MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Object>
         * addGamer(@RequestBody Gamer newGamer) { gamerService.createGamer(newGamer);
         * return new ResponseEntity<Object>(newGamer, HttpStatus.OK);
         */
    }
    // **********************************************
    // @GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
    // MediaType.APPLICATION_JSON_VALUE })
    // public ResponseEntity<List<Gamer>> getAllGamers() {
    // return
    // ResponseEntity.status(HttpStatus.OK).body(gamerService.retrieveAllGamers());
    // }
    //
    // @GetMapping(value = "/gamers/{user_id}", produces = {
    // MediaType.APPLICATION_JSON_VALUE })
    // public ResponseEntity<Gamer> getGamerById(@RequestParam(value = "user_id")
    // Integer user_id) {
    // return
    // ResponseEntity.status(HttpStatus.OK).body(gamerService.retrieveById(user_id));
    // }
    //
    // @PostMapping(value = "/gamers/add", consumes = {
    // MediaType.APPLICATION_JSON_VALUE }, produces = {
    // MediaType.APPLICATION_JSON_VALUE })
    // public ResponseEntity<Gamer> addGamer(@RequestBody Gamer newGamer) {
    // gamerService.createGamer(newGamer);
    // return new ResponseEntity<Gamer>(newGamer, HttpStatus.OK);
    // }
    //
    // @DeleteMapping(value = "gamers/{user_id}", consumes = {
    // MediaType.APPLICATION_JSON_VALUE })
    // public ResponseEntity<String> deleteGamerById(@RequestParam(value =
    // "user_id") Integer user_id) {
    // gamerService.deleteGamer(user_id);
    // return new ResponseEntity<>(HttpStatus.OK);
    // }

}
