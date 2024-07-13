package com.dekankilic.external_api_calls.controller;

import com.dekankilic.external_api_calls.dto.Photo;
import com.dekankilic.external_api_calls.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping("/{albumId}")
    public ResponseEntity<List<Photo>> getAllPhotosOfAlbum(@PathVariable Integer albumId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(photoService.getPhotosByAlbumId(albumId));
    }
}
