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

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Integer id) {
        return goalRepository.findById(id).orElse(null);
    }

    public List<Goal> getGoalByUserId(User user) {
        return goalRepository.findByUser(user);
    }

    public List<Goal> getGoalByStatus(User user, String status) {
        return goalRepository.findByStatusAndUser_Id(status, user.getId());
    }

    public List<Goal> getGoalsByDifficulty(User user, String difficulty) {
        return goalRepository.findByDifficultyAndUser_Id(difficulty, user.getId());
    }

    public List<Goal> getGoalsByType(User user, String goalType) {
        return goalRepository.findByGoalTypeAndUser_Id(goalType, user.getId());
    }

    public Goal createGoal(User user, Goal goal) {
        Goal mockGoal = new Goal(user, goal.getDescription(), goal.getStatus(), goal.getDifficulty(), goal.getGoalType(), goal.getExp(), goal.getCreateAtDate(), goal.getDueDate());
        Goal newGoal = goalRepository.save(mockGoal);
        return newGoal;
    }

    public void deleteGoal(Integer id) {
        goalRepository.deleteById(id);
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
}
