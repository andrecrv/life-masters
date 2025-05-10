package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.dtos.UserDTO;
import com.demomasters.lifemasters.exceptions.DuplicateUserException;
import com.demomasters.lifemasters.exceptions.UserNotFoundException;
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
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
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

    public User createUser(UserDTO userDTO) {
        if (findUserByUsername(userDTO.getUsername()) != null) {
            throw new DuplicateUserException("Username already exists");
        }

        if (findUserByEmail(userDTO.getEmail()) != null) {
            throw new DuplicateUserException("Email already exists");
        }

        User newUser = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), 1, "Newbie");
        return userRepository.save(newUser);
    }

    public User updateUser(Integer id, UserDTO userDTO) {
        User existingUser = getUser(id);

        if (userDTO.getUsername() != null && !userDTO.getUsername().isBlank()) {
            existingUser.setUsername(userDTO.getUsername());
        }

        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            existingUser.setPassword(userDTO.getPassword());
        }

        if (userDTO.getEmail() != null && !userDTO.getEmail().isBlank()) {
            existingUser.setEmail(userDTO.getEmail());
        }

//        if (userDTO.getTitle() != null && !userDTO.getTitle().isBlank()) {
//            existingUser.setTitle(userDTO.getTitle());
//        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
