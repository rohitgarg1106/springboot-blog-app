package com.example.springbootblogapp.entity;

import com.example.springbootblogapp.request.CommentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    public Comment(CommentRequest commentRequest, PostEntity postEntity){
        this.name = commentRequest.getName();
        this.email = commentRequest.getEmail();
        this.body = commentRequest.getBody();
        this.post = postEntity;
    }

}
