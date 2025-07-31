package ru.tsarenko.storage.repository;

import java.util.Optional;

public interface MediaRepository {
    Optional<byte[]> getAudioByFilename(String filename);
}
