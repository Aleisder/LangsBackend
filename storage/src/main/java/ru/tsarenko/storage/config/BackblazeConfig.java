package ru.tsarenko.storage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

@Component
public class BackblazeConfig {

    private final String id;
    private final String key;

    public BackblazeConfig(
            @Value("${backblaze.access.id}") String id,
            @Value("${backblaze.access.key}") String key
    ) {
        this.id = id;
        this.key = key;
    }

    @Component
    public final class BackblazeCredentials implements AwsCredentials {

        @Override
        public String accessKeyId() {
            return id;
        }

        @Override
        public String secretAccessKey() {
            return key;
        }
    }

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
}
