package ru.tsarenko.langs.repository.mongo;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LessonRepository {

    private final MongoTemplate template;

    public LessonRepository(MongoTemplate template) {
        this.template = template;
    }

    public List<Document> getAllLessons() {
        return template.findAll(Document.class,"Lesson");
    }

    public Map<String, Object> getLessonById(String id) {
        Document data = template.findById(new ObjectId(id), Document.class,"Lesson");
        return new HashMap<>(data);
    }
}
