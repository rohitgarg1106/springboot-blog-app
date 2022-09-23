package com.example.springbootblogapp.entity;

import com.example.springbootblogapp.request.PostRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)

public class PostEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;

    public PostEntity(PostRequest postRequest){
        this.title = postRequest.getTitle();
        this.description = postRequest.getDescription();
        this.content = postRequest.getContent();
    }
}
