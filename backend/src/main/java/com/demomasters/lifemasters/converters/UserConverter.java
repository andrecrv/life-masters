package com.demomasters.lifemasters.converters;

import com.demomasters.lifemasters.dtos.UserDTO;
import com.demomasters.lifemasters.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail(), user.getLevel(), user.getTitle());
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setLevel(userDTO.getLevel());
        user.setTitle(userDTO.getTitle());
        return user;
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(user -> new UserDTO(user.getUsername(), user.getPassword(), user.getEmail(), user.getLevel(), user.getTitle()))
                .collect(Collectors.toList());
    }

    public static List<User> toEntityList(List<UserDTO> userDTOs) {
        return userDTOs.stream()
                .map(userDTO -> new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getLevel(), userDTO.getTitle()))
                .collect(Collectors.toList());
    }
}
