package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.converters.GoalConverter;
import com.demomasters.lifemasters.dtos.GoalDTO;
import com.demomasters.lifemasters.exceptions.GoalNotFoundException;
import com.demomasters.lifemasters.exceptions.TaskNotFoundException;
import com.demomasters.lifemasters.exceptions.UnauthorizedAccessException;
import com.demomasters.lifemasters.models.Goal;
import com.demomasters.lifemasters.models.Task;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<GoalDTO> getGoals() {
        List<Goal> goals = goalRepository.findAll();
        return GoalConverter.toDTOList(goals);
    }

    public GoalDTO getGoalById(Integer id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException("Goal with ID " + id + " not found"));
        return GoalConverter.toDTO(goal);
    }

    public List<GoalDTO> getGoalsByUserId(Integer userId) {
        List<Goal> goals = goalRepository.findByUserId(userId);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByStatus(String status) {
        List<Goal> goals = goalRepository.findByStatus(status);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByDifficulty(String difficulty) {
        List<Goal> goals = goalRepository.findByDifficulty(difficulty);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByGoalType(String goalType) {
        List<Goal> goals = goalRepository.findByGoalType(goalType);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByUserIdAndStatus(Integer userId, String status) {
        List<Goal> goals = goalRepository.findByUserIdAndStatus(userId, status);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByUserIdAndDifficulty(Integer userId, String difficulty) {
        List<Goal> goals = goalRepository.findByUserIdAndDifficulty(userId, difficulty);
        return GoalConverter.toDTOList(goals);
    }

    public List<GoalDTO> getGoalsByUserIdAndGoalType(Integer userId, String goalType) {
        List<Goal> goals = goalRepository.findByUserIdAndGoalType(userId, goalType);
        return GoalConverter.toDTOList(goals);
    }

    public GoalDTO createGoal(Integer userId, GoalDTO goalDTO) {
        // TODO: Add validations
        Goal newGoal = GoalConverter.toEntity(goalDTO);

        User user = new User();
        user.setId(userId);
        newGoal.setUser(user);

        Goal createdGoal = goalRepository.save(newGoal);
        return GoalConverter.toDTO(createdGoal);
    }

    public GoalDTO updateGoal(Integer id, GoalDTO goalDTO) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException("Goal with ID " + id + " not found"));

        if (goalDTO.getDescription() != null && !goalDTO.getDescription().isBlank()) {
            goal.setDescription(goalDTO.getDescription());
        }
        if (goalDTO.getStatus() != null && !goalDTO.getStatus().isBlank()) {
            goal.setStatus(goalDTO.getStatus());
        }
        if (goalDTO.getDifficulty() != null && !goalDTO.getDifficulty().isBlank()) {
            goal.setDifficulty(goalDTO.getDifficulty());
        }
        if (goalDTO.getGoalType() != null && !goalDTO.getGoalType().isBlank()) {
            goal.setGoalType(goalDTO.getGoalType());
        }

//        goal.setExp(goalDTO.getExp());
//        goal.setCreateAtDate(goalDTO.getCreateAtDate());
//        goal.setDueDate(goalDTO.getDueDate());

        Goal updatedGoal = goalRepository.save(goal);
        return GoalConverter.toDTO(updatedGoal);
    }

    public void deleteGoal(Integer userId, Integer id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException("Goal with ID " + id + " not found"));

        if (!goal.getUser().getId().equals(userId)) {
            throw new UnauthorizedAccessException("User " + userId + " does not own this task");
        }

        goalRepository.delete(goal);
    }
}
