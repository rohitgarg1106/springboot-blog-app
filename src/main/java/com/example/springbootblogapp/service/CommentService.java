package com.example.springbootblogapp.service;

import com.example.springbootblogapp.entity.Comment;
import com.example.springbootblogapp.entity.PostEntity;
import com.example.springbootblogapp.exception.BadMappingException;
import com.example.springbootblogapp.exception.ResourceNotFoundException;
import com.example.springbootblogapp.repository.CommentRepository;
import com.example.springbootblogapp.repository.PostRepository;
import com.example.springbootblogapp.request.CommentRequest;
import com.example.springbootblogapp.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private  CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public CommentResponse createComment(CommentRequest commentRequest){

        PostEntity postEntity = postRepository.findById(commentRequest.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post","id",String.valueOf(commentRequest.getPostId())));

        Comment comment = new Comment(commentRequest, postEntity);

        Comment newComment = commentRepository.saveAndFlush(comment);

        return new CommentResponse(newComment);
    }

    public List<CommentResponse> getAllCommentsByPostId(long postId){
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","id",String.valueOf(postId)));
        List<Comment> commentList = commentRepository.findAllByPost_Id(postEntity.getId());
        return commentList.stream().map(c -> new CommentResponse(c)).collect(Collectors.toList());
    }

    public CommentResponse getComment(Long postId, Long commentId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","id",String.valueOf(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","id",String.valueOf(commentId)));

        if(comment.getPost().getId() != postId){
            throw new BadMappingException(commentId, postId);
        }

        return new CommentResponse(comment);

    }
}
