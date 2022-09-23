package com.example.springbootblogapp.repository;

import com.example.springbootblogapp.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
