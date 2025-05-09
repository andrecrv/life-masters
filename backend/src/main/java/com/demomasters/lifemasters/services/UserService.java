package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.exceptions.DuplicateUserException;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User createUser(User user) {
        if (findUserByUsername(user.getUsername()) != null) {
            throw new DuplicateUserException("Username already exists");
        }

        if (findUserByEmail(user.getEmail()) != null) {
            throw new DuplicateUserException("Email already exists");
        }

        User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail(), 1, "Newbie");
        return userRepository.save(newUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setLevel(user.getLevel());
        existingUser.setTitle(user.getTitle());

        return userRepository.save(existingUser);
    }
}
