package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);
}