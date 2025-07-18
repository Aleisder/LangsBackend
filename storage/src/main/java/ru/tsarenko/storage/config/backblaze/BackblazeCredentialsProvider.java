package ru.tsarenko.storage.config.backblaze;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

@Component
public final class BackblazeCredentialsProvider implements AwsCredentialsProvider {

    private final AwsCredentials credentials;

    public BackblazeCredentialsProvider(AwsCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public AwsCredentials resolveCredentials() {
        return credentials;
    }
}