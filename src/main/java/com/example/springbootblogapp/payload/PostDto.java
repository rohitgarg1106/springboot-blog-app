package com.example.springbootblogapp.payload;

import com.example.springbootblogapp.entity.PostEntity;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;

    public PostDto(PostEntity postEntity){
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.description = postEntity.getDescription();
        this.content = postEntity.getContent();
    }
}
