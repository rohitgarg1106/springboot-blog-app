package com.example.springbootblogapp.service;

import com.example.springbootblogapp.entity.PostEntity;
import com.example.springbootblogapp.exception.ResourceNotFoundException;
import com.example.springbootblogapp.payload.PostDto;
import com.example.springbootblogapp.repository.PostRepository;
import com.example.springbootblogapp.request.PostRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto createPost(PostRequest postRequest) {
        PostEntity entity = new PostEntity(postRequest);
        PostEntity createdPost = postRepository.saveAndFlush(entity);
        PostDto postDto = new PostDto(createdPost);
        return postDto;
    }

    public PostDto getPostById(Long id) {
        Optional<PostEntity> entityOp = postRepository.findById(id);

        if(!entityOp.isPresent()){
            throw new ResourceNotFoundException("Post", "Id", String.valueOf(id));
        }
        return new PostDto(entityOp.get());
    }
}
