package com.example.springbootblogapp.response;

import com.example.springbootblogapp.entity.Comment;
import com.example.springbootblogapp.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    @JsonProperty("comment_id")
    private long id;

    @JsonProperty("post_id")
    private long postId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("body")
    private String body;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.name = comment.getName();
        this.email = comment.getEmail();
        this.body = comment.getBody();

    }
}
