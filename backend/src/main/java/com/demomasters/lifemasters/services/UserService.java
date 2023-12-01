package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public ResponseEntity<User> createUser(User user) {
        User mockUser = new User(user.getUsername(), user.getPasswd(), user.getEmail(), 1, "Newbie");
        User newUser = repo.save(mockUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public User updateUser(User user) {
        User existingUser = repo.findById(user.getId()).orElse(null);
        return repo.save(existingUser);
    }

    public String deleteUser(int id) {
        repo.deleteById(id);
        return "User was deleted." + id;
    }

    public User findUserByUsername(String username) {
        return repo.findUserByUsername(username);
    }
}
