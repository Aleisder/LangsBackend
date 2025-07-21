package ru.tsarenko.langs.repository;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepository {

    private final MongoTemplate template;

    public LessonRepository(MongoTemplate template) {
        this.template = template;
    }

    public List<Document> getAllLessons() {
        return template.findAll(Document.class,"Lesson");
    }

    public Document getLessonById(String id) {
        return template.findById(new ObjectId(id), Document.class,"Lesson");
    }
}
