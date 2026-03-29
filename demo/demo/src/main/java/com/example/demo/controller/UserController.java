package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user: {}", user);
        return service.saveUser(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return service.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        logger.info("Fetching user with ID: {}", id);
        return service.getUserById(id); // may throw exception
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("Updating user with ID: {}", id);
        user.setId(id);
        return service.saveUser(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with ID: {}", id);
        service.deleteUser(id);
        return "User deleted successfully";
    }
}