package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.converters.UserConverter;
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

    public UserDTO findUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        return UserConverter.toDTO(user);
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return UserConverter.toDTOList(users);
    }

    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username '" + username + "' not found"));
        return UserConverter.toDTO(user);
    }

    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email '" + email + "' not found"));
        return UserConverter.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findUserByUsername(userDTO.getUsername()).isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }

        if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
            throw new DuplicateUserException("Email already exists");
        }

        User newUser = UserConverter.toEntity(userDTO);
        newUser.setLevel(1);
        newUser.setTitle("Initiate");

        User createdUser = userRepository.save(newUser);
        return UserConverter.toDTO(createdUser);
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        // TODO: Add validations
        if (userDTO.getUsername() != null && !userDTO.getUsername().isBlank()) {
            user.setUsername(userDTO.getUsername());
        }

        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            user.setPassword(userDTO.getPassword());
        }

        if (userDTO.getEmail() != null && !userDTO.getEmail().isBlank()) {
            user.setEmail(userDTO.getEmail());
        }

        User updatedUser = userRepository.save(user);
        return UserConverter.toDTO(updatedUser);
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
