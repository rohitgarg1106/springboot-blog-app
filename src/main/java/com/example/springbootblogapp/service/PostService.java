package com.example.springbootblogapp.service;

import com.example.springbootblogapp.entity.PostEntity;
import com.example.springbootblogapp.exception.ResourceNotFoundException;
import com.example.springbootblogapp.payload.PostDto;
import com.example.springbootblogapp.repository.PostRepository;
import com.example.springbootblogapp.request.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PostDto> getAllPosts(int pageNo, int pageSize) {
        Pageable pg =  PageRequest.of(pageNo, pageSize);
        Page <PostEntity> postList = postRepository.findAll(pg);
        List <PostDto> postDtoList = postList.getContent().stream().map(post -> new PostDto(post)).collect(Collectors.toList());
        return postDtoList;
    }


    public PostDto updatePost(PostRequest postRequest, Long id) {
        Optional<PostEntity> entityOp =  postRepository.findById(id);
        if(!entityOp.isPresent()){
            throw new ResourceNotFoundException("Post", "Id", String.valueOf(id));
        }
        PostEntity entity = entityOp.get();
        entity.setContent(postRequest.getContent());
        entity.setDescription(postRequest.getDescription());
        entity.setTitle(postRequest.getTitle());
        PostEntity updatedPost = postRepository.saveAndFlush(entity);
        return new PostDto(updatedPost);

    }
}
