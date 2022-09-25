package com.example.springbootblogapp.exception;

public class BadMappingException extends RuntimeException{

    private Long postId;

    private Long commentId;

    public BadMappingException(Long postId, Long commentId) {
        super(String.format("No mapping exists with %s and %s", postId, commentId));
        this.postId = postId;
        this.commentId = commentId;
    }

    public BadMappingException(String message, Long postId, Long commentId) {
        super(message);
        this.postId = postId;
        this.commentId = commentId;
    }
}
