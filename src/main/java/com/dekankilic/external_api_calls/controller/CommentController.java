package com.dekankilic.external_api_calls.controller;

import com.dekankilic.external_api_calls.dto.Comment;
import com.dekankilic.external_api_calls.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getAllCommentByPostId(@PathVariable Integer postId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.getAllCommentByPostId(postId));
    }
}
