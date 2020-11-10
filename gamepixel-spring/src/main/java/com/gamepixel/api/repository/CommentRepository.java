package com.gamepixel.api.repository;

import java.util.List;

import com.gamepixel.api.models.Comment;
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByGamer(Gamer gamer);
}
