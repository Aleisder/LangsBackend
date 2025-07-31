package ru.tsarenko.storage.repository;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MinioRepository implements MediaRepository {

    private final MinioClient minioClient;

    public MinioRepository(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public Optional<byte[]> getAudioByFilename(String filename) {
        try {
            var request = GetObjectArgs.builder()
                    .bucket("audio")
                    .object(filename)
                    .build();
            var stream = minioClient.getObject(request);
            return Optional.of(stream.readAllBytes());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
