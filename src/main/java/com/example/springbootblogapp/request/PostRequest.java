package com.example.springbootblogapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String content;
}
