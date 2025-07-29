package ru.tsarenko.education.controller;

import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsarenko.education.service.LessonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/education/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/all")
    public List<Document> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getLesson(@PathVariable String id) {
        return lessonService.getLessonById(id);
    }
}
