package ru.tsarenko.storage.service;

import org.springframework.stereotype.Service;
import ru.tsarenko.storage.exception.NoFileFoundException;
import ru.tsarenko.storage.repository.BackblazeRepository;

@Service
public class MediaService {

    private final BackblazeRepository backblazeRepository;

    public MediaService(BackblazeRepository backblazeRepository) {
        this.backblazeRepository = backblazeRepository;
    }

    public byte[] getAudioByFilename(String filename) {
        return backblazeRepository
                .getAudioByFilename(filename)
                .orElseThrow(() -> new NoFileFoundException(filename));
    }
}
