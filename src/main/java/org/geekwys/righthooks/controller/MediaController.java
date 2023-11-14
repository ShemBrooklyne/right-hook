package org.geekwys.righthooks.controller;

import org.geekwys.righthooks.gallery.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/media")
public class MediaController {

    private final StorageService storageService;

    public MediaController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadMedia(@RequestParam("media") MultipartFile file) throws IOException {
        String upload = storageService.uploadMedia(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(upload);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadMedia(@PathVariable String fileName) {
        byte[] mediaData = storageService.downloadMedia(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(mediaData);
    }

}
