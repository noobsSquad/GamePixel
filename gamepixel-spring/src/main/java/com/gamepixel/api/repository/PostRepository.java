package com.gamepixel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.models.content.Post;
import com.gamepixel.api.models.content.Tag;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

    List<Post> findAllByTags(Tag tag);

}
