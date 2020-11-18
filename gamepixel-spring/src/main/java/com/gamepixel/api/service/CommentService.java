package com.gamepixel.api.service;

import java.util.List;

import com.gamepixel.api.dto.CommentDto;
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.repository.CommentRepository;
import com.gamepixel.api.repository.GamerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    GamerRepository gamerRepository;

    // save comment to db
    public void saveComment(CommentDto commentDto) {
        // query first if post exists
        // else: throw error postNotFoundException

        // save comment based on mapstruct method
    }

    // find comments by username
    public List<CommentDto> getAllCommentsFromPost(Long postId) {
        // find post by its id
        // else: throw error
        // return a list of comments
        return null;
    }

    // find comment by post
    public List<CommentDto> getAllCommentsFromGamer(String username) {
        // find posts by gamer's username
        // else: throw exception

        // return list of comments
        return null;
    }

    // send mail notification to email
    private void sendCommentNotification(String message, Gamer gamer) {
        // required: create mail service layer first
    }

    // deleting comment from post

    // editing comment from post
}
