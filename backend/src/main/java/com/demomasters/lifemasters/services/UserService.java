package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User createUser(User user) {
        User mockUser = new User(user.getUsername(), user.getPassword(), user.getEmail(), 1, "Newbie");
        User newUser = userRepository.save(mockUser);
        return newUser;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(int userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if(existingUser == null){
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
