package com.gamepixel.api.service;

import com.gamepixel.api.dto.post.PostRequest;
import com.gamepixel.api.dto.post.PostResponse;
import com.gamepixel.api.exceptions.PostNotFoundException;
import com.gamepixel.api.exceptions.TagNotFoundException;
import com.gamepixel.api.mapper.PostMapper;
import com.gamepixel.api.models.content.Post;
import com.gamepixel.api.models.content.Tag;
import com.gamepixel.api.repository.PostRepository;
import com.gamepixel.api.repository.TagRepository;
import com.gamepixel.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final TagRepository tagRepository;
    private final AuthService authService;
    private final UserRepository userRepository;

    public void save(PostRequest postRequest) {
        Set<Tag> tags = new HashSet<>();
        Iterator<String> it = postRequest.getTags().iterator();
        while (it.hasNext()) {
            Tag tag = tagRepository.findByName(it.next()).orElse(new Tag()); // tagRepository.save(newTag())
            tags.add(tag);
        }
        postRepository.save(postMapper.map(postRequest, tags, authService.getCurrentUser()));
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    public List<PostResponse> getAllPosts() {
        // find all posts, stream ,map with the function mapToDto in postMapper, and add
        // them to a list
        return postRepository.findAll().stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    // public List<PostResponse> getPostByUsername(String username){
    // User user = userRepository.findByUsername(username).orElseThrow(() -> new
    // UserNotFoundException("User Not found!"));
    // return postRepository.findByUser(user)
    // .stream().map(postMapper::mapToDto)
    // .collect(Collectors.toList());
    // }
    public List<PostResponse> getPostsByTag(String tagName) {
        Tag tag = tagRepository.findByName(tagName)
                .orElseThrow(() -> new TagNotFoundException("Tag: " + tagName + " not found"));
        List<Post> posts = postRepository.findAllByTags(tag);
        return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }
}