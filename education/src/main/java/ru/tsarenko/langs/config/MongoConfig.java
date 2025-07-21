package ru.tsarenko.langs.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    private final String mongoUrl;
    private final String databaseName;

    public MongoConfig(
            @Value("${mongo.database.url}") String mongoUrl,
            @Value("${mongo.database.name}") String databaseName
    ) {
        this.mongoUrl = mongoUrl;
        this.databaseName = databaseName;
    }

    @Bean
    public MongoClient getMongoClient() {
        return MongoClients.create(mongoUrl);
    }

    @Bean
    public MongoTemplate getMongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, databaseName);
    }
}
