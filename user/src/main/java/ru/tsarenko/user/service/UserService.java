package ru.tsarenko.user.service;

import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.tsarenko.user.model.AddUserRequestBody;
import ru.tsarenko.user.model.Language;
import ru.tsarenko.user.model.User;
import ru.tsarenko.user.repository.postgres.LanguageRepository;
import ru.tsarenko.user.repository.postgres.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;

    //private final KafkaService kafkaService;

    public UserService(UserRepository userRepository, LanguageRepository languageRepository) {
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        //this.kafkaService = kafkaService;
    }

    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with id %d found".formatted(id))
                );
    }

    public void addUser(AddUserRequestBody userBody) {

        List<Language> languages = languageRepository.findAll();





        //kafkaService.sendWelcomeEmail(mail);
    }
}
