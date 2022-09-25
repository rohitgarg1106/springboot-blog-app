package com.example.springbootblogapp.response;

import com.example.springbootblogapp.payload.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedResponse {

    private List<PostDto> postDtoList;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private int size;
    private int number;


}
