package com.gamepixel.api.repository;

import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.models.content.Comment;
import com.gamepixel.api.models.content.Post;
import com.gamepixel.api.models.content.Tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    Comment comment = new Comment();

    @BeforeEach
    void setUp() throws Exception {
       
        comment.setId(1L);
        comment.setContent("hello I'm new here :)");
        comment.setCreatedOn(Instant.now());
        comment.setPost(null);
        comment.setUser(null);

        commentRepository.save(comment);
    }

    @Test
    void testUpdateComment() {
       
        
        String newComment = "I like your cut G!";
        Instant updatedTime = Instant.now().plusSeconds(30);

        commentRepository.updateComment(newComment, updatedTime, 1L); 
        
        String storedContent = comment.getContent();
        Instant storedTime = comment.getCreatedOn();

        assertTrue(storedContent == comment.getContent());
        assertTrue(storedTime != comment.getCreatedOn());

        
    }
}
