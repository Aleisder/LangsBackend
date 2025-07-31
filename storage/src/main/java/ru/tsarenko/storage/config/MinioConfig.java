package ru.tsarenko.storage.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    public MinioClient getMinioClient(
            @Value("${minio.url}") String url,
            @Value("${minio.user}") String user,
            @Value("${minio.password}") String password
    ) {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(user, password)
                .build();
    }
}
