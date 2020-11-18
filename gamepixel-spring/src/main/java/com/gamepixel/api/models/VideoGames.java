package com.gamepixel.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VideoGames {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    @NonNull
    private String title;
    private String genre;
    private Integer rating;
    private Date releasedDate;
    private String developers;
    private String publishers;
    // videos are in which platforms? // removing a game shouldn't remove a platform
//    @ManyToMany(cascade = CascadeType.ALL)
//    List<Platform> platforms;
}
