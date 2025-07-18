package ru.tsarenko.storage.config.backblaze;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentials;

@Component
public class BackblazeCredentials implements AwsCredentials {

    private final String id;
    private final String key;

    public BackblazeCredentials(
            @Value("${backblaze.access.id}") String id,
            @Value("${backblaze.access.key}")String key
    ) {
        this.id = id;
        this.key = key;
    }

    @Override
    public String accessKeyId() {
        return id;
    }

    @Override
    public String secretAccessKey() {
        return key;
    }
}