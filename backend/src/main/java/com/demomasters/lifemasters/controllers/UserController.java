package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PutMapping("/user/{id}/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
