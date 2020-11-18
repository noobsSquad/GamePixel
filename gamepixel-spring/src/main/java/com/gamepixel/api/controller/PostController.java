package com.gamepixel.api.controller;

import com.gamepixel.api.dto.PostRequest;
import com.gamepixel.api.dto.PostResponse;
import com.gamepixel.api.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@Controller
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest){
        postService.save(postRequest);
        return new ResponseEntity<>(CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(){
        return status(OK).body(postService.getAllPosts());
    }
    @GetMapping({"/{id}"})
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id){
        return status(OK).body(postService.getPost(id));
    }

//    @GetMapping("/by-username{username}")
//    public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String username){
//        return status(OK).body(postService.getPostByUsername(username));
//    }
    @GetMapping("/by-tag{tag}")
    public ResponseEntity<List<PostResponse>> getPostsByTag(@PathVariable String tag){
        return status(OK).body(postService.getPostsByTag(tag));
    }

}
