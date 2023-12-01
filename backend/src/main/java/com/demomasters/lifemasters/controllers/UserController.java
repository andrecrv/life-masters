package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public String displayDBEntry() {
        return "You've entered the LifeMasters Secret DataBase.";
    }

    @PostMapping("/api/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PutMapping("/api/user/{id}/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/api/user/{id}/delete")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    @GetMapping("/api/username/{username}")
    public User getUserByUsername(@PathVariable String username){
        return service.findUserByUsername(username);
    }
}
