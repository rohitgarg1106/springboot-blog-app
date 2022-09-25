package com.example.springbootblogapp.controller;

import com.example.springbootblogapp.request.CommentRequest;
import com.example.springbootblogapp.response.CommentResponse;
import com.example.springbootblogapp.service.CommentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "comments")
    public ResponseEntity<?> createComment(
            @RequestBody CommentRequest commentRequest
            ){
        CommentResponse commentResponse = commentService.createComment(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }
}
