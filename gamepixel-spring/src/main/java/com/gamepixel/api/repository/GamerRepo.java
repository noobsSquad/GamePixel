package com.gamepixel.api.repository;

import com.gamepixel.api.models.Gamer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepo extends JpaRepository<Gamer, Integer> {

}
