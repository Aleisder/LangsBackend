package ru.tsarenko.user.controller;

import org.springframework.web.bind.annotation.*;
import ru.tsarenko.user.model.User;
import ru.tsarenko.user.service.UserService;

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
