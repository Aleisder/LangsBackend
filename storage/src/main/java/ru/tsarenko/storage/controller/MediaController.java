package ru.tsarenko.storage.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsarenko.storage.service.MediaService;

@RestController
@RequestMapping("/storage/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping(
            value = "/audio/{filename}"
    )
    public ResponseEntity<byte[]> getAudio(@PathVariable String filename) {
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("audio/mpeg"))
                .body(mediaService.getAudioByFilename(filename));
    }
}
