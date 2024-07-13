package com.dekankilic.external_api_calls.dto;

public record Photo(
        Long albumId,
        Long id,
        String title,
        String url,
        String thumbnailUrl
) {
}
