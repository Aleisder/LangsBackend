package ru.tsarenko.langs.service;

import org.bson.Document;
import org.springframework.stereotype.Service;
import ru.tsarenko.langs.repository.mongo.LessonRepository;
import ru.tsarenko.langs.repository.redis.CachedLessonRepository;

import java.util.List;
import java.util.Map;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CachedLessonRepository cachedLessonRepository;

    private final static int DAY_IN_SECONDS = 86400;

    public LessonService(
            LessonRepository lessonRepository,
            CachedLessonRepository cachedLessonRepository
    ) {
        this.lessonRepository = lessonRepository;
        this.cachedLessonRepository = cachedLessonRepository;
    }

    public List<Document> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    public Map<String, Object> getLessonById(String id) {
        var cache = cachedLessonRepository.getCachedLessonById(id);
        if (cache.isPresent()) {
            return cache.get();
        }
        var lesson = lessonRepository.getLessonById(id);
        cachedLessonRepository.saveLesson(id, lesson, DAY_IN_SECONDS);
        return lesson;
    }
}
