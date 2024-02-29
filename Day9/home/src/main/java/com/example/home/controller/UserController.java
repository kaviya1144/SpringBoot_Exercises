package com.example.home.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.home.model.User;
import com.example.home.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/User")
    public ResponseEntity<User> createUser(@RequestBody User User) {
        try {
            User createdUser = userService.createUser(User);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/UserName/{userName}")
    public ResponseEntity<List<User>> getByName(@PathVariable("userName") String userName) {
        List<User> UserbyName = userService.getUserByName(userName);
        if (UserbyName != null) {
            return new ResponseEntity<>(UserbyName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/UserId/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") int userId) {
        User UserbyId = userService.getUserById(userId);
        if (UserbyId != null) {
            return new ResponseEntity<>(UserbyId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
