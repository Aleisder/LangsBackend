package ru.tsarenko.education.repository.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.json.Path2;

import java.util.Map;
import java.util.Optional;

@Repository
public class CachedLessonRepository {

    private final JedisPooled jedis;

    public CachedLessonRepository(JedisPooled jedis) {
        this.jedis = jedis;
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
            throw new RuntimeException("Something went wrong");
        }
    }
}
