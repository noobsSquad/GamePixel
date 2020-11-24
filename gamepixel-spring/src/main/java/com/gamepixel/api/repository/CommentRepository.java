package com.gamepixel.api.repository;

import java.time.Instant;
import java.util.List;

import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.models.content.Comment;
import com.gamepixel.api.models.content.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);

    @Modifying
    @Query("UPDATE comment c SET c.content = ?1, c.createdOn = ?2 WHERE c.id = ?3")
    Comment updateComment(String content, Instant createdOn , Long id);
    
    
}
