package com.gamepixel.api.repository;

import com.gamepixel.api.models.Gamer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface GamerRepo extends JpaRepository<Gamer, Long> {
    Optional<Gamer> findByUsername(String userName); // -> Select username From Gamers where username = ?
}
