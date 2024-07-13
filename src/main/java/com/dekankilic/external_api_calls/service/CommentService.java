package com.dekankilic.external_api_calls.service;

import com.dekankilic.external_api_calls.dto.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CommentService {
    private final RestClient restClient;

    public CommentService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com/comments")
                .build();
    }

    public List<Comment> getAllCommentByPostId(Integer postId){
        return restClient.get()
                .uri("?postId=" + postId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Comment>>() {});
    }
}
