package ru.tsarenko.langs.service;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.tsarenko.langs.repository.LessonRepository;

import javax.print.Doc;
import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Document> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    public Document getLessonById(String id) {
        return lessonRepository.getLessonById(id);
    }
}
