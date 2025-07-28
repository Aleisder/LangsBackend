package ru.tsarenko.langs.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import ru.tsarenko.langs.model.User;
import ru.tsarenko.langs.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestParam("mail") String mail) {
        userService.createUser(mail);
    }
}
