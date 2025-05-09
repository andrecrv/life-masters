package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}