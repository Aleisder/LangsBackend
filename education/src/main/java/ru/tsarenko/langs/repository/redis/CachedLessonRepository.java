package ru.tsarenko.langs.repository.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.json.Path2;

import java.util.Map;
import java.util.Optional;

@Repository
public class CachedLessonRepository {

    private final JedisPooled jedis;

    public CachedLessonRepository(
            @Value("${redis.host}") String host,
            @Value("${redis.port}") int port
    ) {
        this.jedis = new JedisPooled(host, port);
    }

    public Optional<Map<String, Object>>  getCachedLessonById(String id) {
        var key = "lesson:%s".formatted(id);
        try {
            Map<String, Object> json = jedis.jsonGet(key, Map.class);
            return Optional.of(json);
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public void saveLesson(String id, Map<String, Object> lesson, int ttl) {
        var key = "lesson:%s".formatted(id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(lesson);
            jedis.jsonSet(key, Path2.ROOT_PATH, json);
            jedis.expire(key, ttl);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("А НЕ ПОЛУЧИЛОСЬ");
        }
    }
}
