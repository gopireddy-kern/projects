package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // CREATE / UPDATE
    public User saveUser(User user) {
        return repository.save(user);
    }

    // READ ALL
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // READ BY ID (WITH CUSTOM EXCEPTION)
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }

    // DELETE
    public void deleteUser(Long id) {
        User user = getUserById(id); // ensures exception if not found
        repository.delete(user);
    }
}