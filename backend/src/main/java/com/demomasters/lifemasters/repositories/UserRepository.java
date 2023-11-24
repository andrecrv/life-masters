package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed
}