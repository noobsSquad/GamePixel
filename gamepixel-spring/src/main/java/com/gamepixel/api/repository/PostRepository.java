package com.gamepixel.api.repository;

import java.util.List;

import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByGamer(Gamer gamer);
}
