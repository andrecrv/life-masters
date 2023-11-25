package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User user) {
        return repo.save(user);
    }

    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public User updateUser(User user) {
        User existingUser = repo.findById(user.getUser_id()).orElse(null);
        return repo.save(existingUser);
    }

    public String deleteUser(int id) {
        repo.deleteById(id);
        return "User was deleted." + id;
    }
}
