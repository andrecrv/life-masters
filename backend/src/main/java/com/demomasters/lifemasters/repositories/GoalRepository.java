package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    List<Goal> findByUserId(Integer userId);

    List<Goal> findByStatus(String status);

    List<Goal> findByDifficulty(String difficulty);

    List<Goal> findByGoalType(String goalType);

    List<Goal> findByUserIdAndStatus(Integer userId, String status);

    List<Goal> findByUserIdAndDifficulty(Integer userId, String difficulty);

    List<Goal> findByUserIdAndGoalType(Integer userId, String goalType);
}
