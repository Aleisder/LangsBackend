package ru.tsarenko.storage.service;

import org.springframework.stereotype.Service;
import ru.tsarenko.storage.exception.NoFileFoundException;
import ru.tsarenko.storage.repository.MediaRepository;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public byte[] getAudioByFilename(String filename) {
        return mediaRepository
                .getAudioByFilename(filename)
                .orElseThrow(() -> new NoFileFoundException(filename));
    }
}
