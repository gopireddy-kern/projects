package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE / UPDATE
    public User saveUser(User user) {
        logger.info("Saving user: {}", user.getName());
        try {
            return repository.save(user);
        } catch (Exception e) {
            logger.error("Error saving user", e);
            throw e;
        }
    }

    // ✅ READ ALL
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return repository.findAll();
    }

    // ✅ READ BY ID
    public User getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);

        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with id: {}", id);
                    return new ResourceNotFoundException("User not found with id: " + id);
                });
    }

    // ✅ DELETE
    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);

        User user = getUserById(id); // ensures exception if not found

        try {
            repository.delete(user);
            logger.info("User deleted successfully with id: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting user with id: {}", id, e);
            throw e;
        }
    }
}