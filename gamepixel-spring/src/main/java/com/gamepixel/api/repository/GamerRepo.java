package com.gamepixel.api.repository;

import com.gamepixel.api.models.Gamer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamerRepo extends JpaRepository<Gamer, Integer> {

}
