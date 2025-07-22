package ru.tsarenko.notification.config.kafka;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
public class KafkaConsumerConfig {
    private final Map<String, Object> config;

    public KafkaConsumerConfig(
            @Value("${spring.kafka.bootstrap-servers}") String bootstrapServers
    ) {
        this.config = new HashMap<>(Map.of(
                BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class,
                VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class
        ));
    }

    @Bean
    public ConsumerFactory<String, String> getConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> getListenerFactory(
            ConsumerFactory<String, String> consumerFactory
    ) {
        return new ConcurrentKafkaListenerContainerFactory<String, String>() {{
            setConsumerFactory(consumerFactory);
        }};
    }
}
