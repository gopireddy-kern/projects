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
        try {
            logger.info("Creating user: {}", user);
            User savedUser = service.saveUser(user);
            logger.info("User created successfully with ID: {}", savedUser.getId());
            return savedUser;
        } catch (Exception e) {
            logger.error("Error while creating user", e);
            throw e;
        }
    }

    // READ ALL
    @GetMapping
    public List<User> getAllUsers() {
        try {
            logger.info("Fetching all users");
            List<User> users = service.getAllUsers();
            logger.info("Total users fetched: {}", users.size());
            return users;
        } catch (Exception e) {
            logger.error("Error while fetching all users", e);
            throw e;
        }
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        try {
            logger.info("Fetching user with ID: {}", id);
            User user = service.getUserById(id);
            logger.info("User fetched successfully: {}", user);
            return user;
        } catch (Exception e) {
            logger.error("Error while fetching user with ID: {}", id, e);
            throw e;
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            logger.info("Updating user with ID: {}", id);
            user.setId(id);
            User updatedUser = service.saveUser(user);
            logger.info("User updated successfully: {}", updatedUser);
            return updatedUser;
        } catch (Exception e) {
            logger.error("Error while updating user with ID: {}", id, e);
            throw e;
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            logger.info("Deleting user with ID: {}", id);
            service.deleteUser(id);
            logger.info("User deleted successfully with ID: {}", id);
            return "User deleted successfully";
        } catch (Exception e) {
            logger.error("Error while deleting user with ID: {}", id, e);
            throw e;
        }
    }
}