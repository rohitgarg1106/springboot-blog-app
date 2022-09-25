package com.example.springbootblogapp.repository;

import com.example.springbootblogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPost_Id(long postId);
}
