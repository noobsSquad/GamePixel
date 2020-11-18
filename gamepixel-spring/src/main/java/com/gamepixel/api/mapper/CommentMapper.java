package com.gamepixel.api.mapper;

import com.gamepixel.api.dto.CommentDto;
import com.gamepixel.api.models.Comment;
import com.gamepixel.api.models.Gamer;
import com.gamepixel.api.models.Post;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper COMM = Mappers.getMapper(CommentMapper.class);

    // Grab the gamer's Id from the post -> CommentDto's postId
    // Grab gamer's username -> CommentDto's username
    @Mapping(expression = "java(comment.getPost().getId())", target = "postId")
    @Mapping(expression = "java(comment.getPost().getGamer().getUsername()", target = "username")
    CommentDto mapToDto(Comment comment);

    // Comment Response Mapper
    @Mapping(ignore = true, target = "id")
    @Mapping(source = "commentDto.review", target = "review")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "gamer", target = "gamer")
    @Mapping(expression = "java(java.time.Instant.now())", target = "createdAt")
    Comment map(CommentDto commentDto, Gamer gamer, Post post);

}
