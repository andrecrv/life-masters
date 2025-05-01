package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.models.Goal;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Integer id) {
        return goalRepository.findById(id).orElse(null);
    }

    public List<Goal> getGoalsByUserId(Integer userId) {
        return goalRepository.findByUserId(userId);
    }

    public List<Goal> getGoalsByStatus(String status) {
        return goalRepository.findByStatus(status);
    }

    public List<Goal> getGoalsByDifficulty(String difficulty) {
        return goalRepository.findByDifficulty(difficulty);
    }

    public List<Goal> getGoalsByGoalType(String goalType) {
        return goalRepository.findByGoalType(goalType);
    }

    public List<Goal> getGoalsByUserIdAndStatus(Integer userId, String status) {
        return goalRepository.findByUserIdAndStatus(userId, status);
    }

    public List<Goal> getGoalsByUserIdAndDifficulty(Integer userId, String difficulty) {
        return goalRepository.findByUserIdAndDifficulty(userId, difficulty);
    }

    public List<Goal> getGoalsByUserIdAndGoalType(Integer userId, String goalType) {
        return goalRepository.findByUserIdAndGoalType(userId, goalType);
    }

    public Goal createGoal(User user, Goal goal) {
        Goal mockGoal = new Goal(user, goal.getDescription(), goal.getStatus(), goal.getDifficulty(), goal.getGoalType(), goal.getExp(), goal.getCreateAtDate(), goal.getDueDate());
        Goal newGoal = goalRepository.save(mockGoal);
        return newGoal;
    }

    public Goal updateGoal(Integer id, Goal goal) {
        Goal existingGoal = getGoalById(id);

        if (existingGoal == null) {
            return null;
        }
        existingGoal.setDescription(goal.getDescription());
        existingGoal.setStatus(goal.getStatus());
        existingGoal.setDifficulty(goal.getDifficulty());
        existingGoal.setGoalType(goal.getGoalType());
        existingGoal.setExp(goal.getExp());
        existingGoal.setCreateAtDate(goal.getCreateAtDate());
        existingGoal.setDueDate(goal.getDueDate());

        return goalRepository.save(existingGoal);
    }

    public void deleteGoal(Integer id) {
        goalRepository.deleteById(id);
    }
}
