package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.Goal;
import com.demomasters.lifemasters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    List<Goal> findByUser(User user);

    List<Goal> findByStatusAndUser_Id(String status, int userId);

    List<Goal> findByDifficultyAndUser_Id(String difficulty, int userId);

    List<Goal> findByGoalTypeAndUser_Id(String goalType, int userId);
}
