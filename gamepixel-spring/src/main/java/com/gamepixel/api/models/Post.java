package com.gamepixel.api.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_desc")
    private String postContent;

    // Don't use JoinColumn to map; use @OneToMany
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    // @JoinColumn(name = "comment_id")
    private List<Comment> comments = new ArrayList<>();
    // Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gamer gamer;

    private Instant createdAt;
}
