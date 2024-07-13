package com.dekankilic.external_api_calls.dto;

public record Comment(
        Integer postId,
        Integer id,
        String name,
        String email,
        String body
) {
}
