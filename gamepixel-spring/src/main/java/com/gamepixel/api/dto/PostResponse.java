package com.gamepixel.api.dto;

import com.gamepixel.api.models.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String username;
    private Set<Tag> tags; // as string as an array as set -> [FPS] [tag] [tag] "
//    private String tags;

    private Integer voteCount;

    private Integer commentCount; // to see how many comments are per vote
}
