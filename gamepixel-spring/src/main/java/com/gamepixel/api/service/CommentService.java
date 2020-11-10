package com.gamepixel.api.service;

import com.gamepixel.api.repository.CommentRepository;
import com.gamepixel.api.repository.GamerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.CommentToken;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

}
