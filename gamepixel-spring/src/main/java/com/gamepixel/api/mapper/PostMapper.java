package com.gamepixel.api.mapper;

import com.gamepixel.api.dto.post.PostRequest;
import com.gamepixel.api.dto.post.PostResponse;
import com.gamepixel.api.models.content.Post;
import com.gamepixel.api.models.content.Tag;
import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    private AuthService authService; // to get User from context holder

    @Mapping(target = "title", source = "postRequest.title")
    @Mapping(target = "url", source = "postRequest.url")
    @Mapping(target = "content", source = "postRequest.content")
    @Mapping(target = "createdOn", expression = "java(java.time.Instant.now())")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "voteCount", constant = "0")
    public abstract Post map(PostRequest postRequest, Set<Tag> tags, User user);

    // Missing username Connection between post and USER
    @Mapping(target = "id", source = "post.id")
    @Mapping(target = "title", source = "post.title")
    @Mapping(target = "url", source = "post.url")
    @Mapping(target = "content", source = "post.content")
    @Mapping(target = "tags", source = "post.tags")
    public abstract PostResponse mapToDto(Post post);

}
