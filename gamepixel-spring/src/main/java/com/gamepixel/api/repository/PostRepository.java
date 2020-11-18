package com.gamepixel.api.repository;

import com.gamepixel.api.models.Post;
import com.gamepixel.api.models.Tag;
import com.gamepixel.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
//    List<Post> findByUser(User user);

    List<Post> findAllByTags(Tag tag);
}
