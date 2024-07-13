package com.dekankilic.external_api_calls.service;


import com.dekankilic.external_api_calls.dto.Photo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhotoService {
    private final RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    public List<Photo> getPhotosByAlbumId(Integer albumId) {
        final ParameterizedTypeReference<List<Photo>> parameterized = new ParameterizedTypeReference<List<Photo>>() {};

        try {
            // If you need to send some headers with your request, you need to construct them
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-KEY", "ads3434");
            headers.set("X-HOST-KEY", "asd123");

            // Make a GET call to the api
            ResponseEntity<List<Photo>> responseEntity = restTemplate.exchange(
                    url + albumId,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    parameterized
            );

            log.info("The output from json place holder api: {}", responseEntity.getBody());

            return responseEntity.getBody();

        } catch (RestClientException e) {
            log.error("Something went wrong while getting value from json place holder api");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint of RapidAPI for corona");
        }
    }
}
