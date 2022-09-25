package com.example.springbootblogapp.payload;

import com.example.springbootblogapp.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
