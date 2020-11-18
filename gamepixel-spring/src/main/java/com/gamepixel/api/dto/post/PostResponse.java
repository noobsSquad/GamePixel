package com.gamepixel.api.dto.post;

import java.time.Instant;

public class PostResponse {
    private Long id;
    private String postName;
    private String url;
    private String content;
    private String username;
    private Integer voteCount;
    private Integer commentCount;
    private Instant duration;
}
