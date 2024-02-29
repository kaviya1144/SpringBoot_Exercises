package com.example.home.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.home.model.User;
import com.example.home.repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getUserByName(String userName) {
        return userRepo.findByUserName(userName);
    }
    public User getUserById(int userId) {
        Optional<User> obj = userRepo.findById(userId);
        return obj.orElse(new User());
    }
}
