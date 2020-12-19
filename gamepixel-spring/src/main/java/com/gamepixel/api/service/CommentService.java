package com.gamepixel.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gamepixel.api.dto.comment.CommentDto;
import com.gamepixel.api.exceptions.PostNotFoundException;
import com.gamepixel.api.exceptions.UserNotFoundException;
import com.gamepixel.api.mapper.CommentMapper;
import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.models.content.Comment;
// import com.gamepixel.api.models.content.Comment;
import com.gamepixel.api.models.content.Post;
import com.gamepixel.api.repository.CommentRepository;
import com.gamepixel.api.repository.PostRepository;
import com.gamepixel.api.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {

    CommentRepository commentRepository;

    UserRepository userRepository;

    PostRepository postRepository;

    AuthService authService;

    CommentMapper commentMapper;

    // save comment to db
    public void saveComment(CommentDto commentDto) {
        // query first if post exists
        // else: throw error postNotFoundException
        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post not found")); 
        
        commentRepository.save(commentMapper.map(commentDto, authService.getCurrentUser(), post));
    }

    // find comments by username
    public List<CommentDto> getAllCommentsFromPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
        return commentRepository
                .findByPost(post)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    // find comment by post
    public List<CommentDto> getAllCommentsFromUser(String username) {
       User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User not Found"));

        return commentRepository
            .findAllByUser(user)
            .stream()
            .map(commentMapper::mapToDto)
            .collect(Collectors.toList());
    }

    // send mail notification to email
    private void sendCommentNotification(String message, User gamer) {
        // required: create mail service layer first
    }

    // delete comment from post
    public void deleteCommentByPost(Long postId) {
       
        
    }

    // edit comment from post
    public void editComment() {
        //need to develop a JPQL query to update comment
        
        return;
    }

}
