package ru.tsarenko.storage.repository;

import org.springframework.stereotype.Repository;
import ru.tsarenko.storage.config.backblaze.BackblazeCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@Repository
public class BackblazeRepository {

    private final S3Client client;

    public BackblazeRepository(BackblazeCredentialsProvider credentialsProvider) throws URISyntaxException {
        client = S3Client.builder()
                .region(Region.of("eu-central-003"))
                .credentialsProvider(credentialsProvider)
                .endpointOverride(new URI("https://s3.eu-central-003.backblazeb2.com"))
                .build();
    }

    public Optional<byte[]> getAudioByFilename(String fileName) {
        try {
            return Optional.of(
                    client.getObject(
                            GetObjectRequest.builder()
                                    .bucket("LangsStorage")
                                    .key("audio/" + fileName)
                                    .build()
                    ).readAllBytes()
            );
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}
