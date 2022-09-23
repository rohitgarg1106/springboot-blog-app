package com.example.springbootblogapp.controller;

import com.example.springbootblogapp.payload.PostDto;
import com.example.springbootblogapp.request.PostRequest;
import com.example.springbootblogapp.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(
            @RequestBody PostRequest postRequest
    ){
        PostDto postDto = postService.createPost(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(postDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getPost(
            @PathVariable Long id
    ){
      PostDto postDto = postService.getPostById(id);
      return ResponseEntity.status(HttpStatus.OK).body(postDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        List<PostDto> postDtoList = postService.getAllPosts(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(postDtoList);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> updatePost(
            @PathVariable Long id,
            @RequestBody PostRequest postRequest
    ){
        PostDto postDto = postService.updatePost(postRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(postDto);

    }
}
