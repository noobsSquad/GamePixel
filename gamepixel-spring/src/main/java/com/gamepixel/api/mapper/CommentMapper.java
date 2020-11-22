package com.gamepixel.api.mapper;

import com.gamepixel.api.dto.comment.CommentDto;
import com.gamepixel.api.models.content.Comment;
import com.gamepixel.api.models.auth.User;
import com.gamepixel.api.models.content.Post;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper COMM = Mappers.getMapper(CommentMapper.class);

    // Grab the gamer's Id from the post -> CommentDto's postId
    // Grab gamer's username -> CommentDto's username
    @Mapping(expression = "java(comment.getPost().getId())", target = "postId")
    @Mapping(expression = "java(comment.getPost().getUser().getUsername())", target = "username")
    CommentDto mapToDto(Comment comment);

    // Comment Response Mapper
    @Mapping(ignore = true, target = "id")
    @Mapping(source = "commentDto.content", target = "content")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "user", target = "user")
    @Mapping(expression = "java(java.time.Instant.now())", target = "createdOn")
    Comment map(CommentDto commentDto, User user, Post post);

}
