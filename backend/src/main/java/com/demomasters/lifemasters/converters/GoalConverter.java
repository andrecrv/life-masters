package com.demomasters.lifemasters.converters;

import com.demomasters.lifemasters.dtos.GoalDTO;
import com.demomasters.lifemasters.models.Goal;

import java.util.List;
import java.util.stream.Collectors;

public class GoalConverter {

    public static GoalDTO toDTO(Goal goal) {
        return new GoalDTO(goal.getId(), goal.getUserId(), goal.getDescription(), goal.getStatus(), goal.getDifficulty(), goal.getGoalType(), goal.getExp(), goal.getCreateAtDate(), goal.getDueDate());
    }

    public static Goal toEntity(GoalDTO goalDTO) {
        Goal goal = new Goal();
        goal.setDescription(goalDTO.getDescription());
        goal.setStatus(goalDTO.getStatus());
        goal.setDifficulty(goalDTO.getDifficulty());
        goal.setGoalType(goalDTO.getGoalType());
        goal.setExp(goalDTO.getExp());
        goal.setCreateAtDate(goalDTO.getCreateAtDate());
        goal.setDueDate(goalDTO.getDueDate());
        return goal;
    }

    public static List<GoalDTO> toDTOList(List<Goal> goals) {
        return goals.stream()
                .map(goal -> new GoalDTO(goal.getId(), goal.getUserId(), goal.getDescription(), goal.getStatus(), goal.getDifficulty(), goal.getGoalType(), goal.getExp(), goal.getCreateAtDate(), goal.getDueDate()))
                .collect(Collectors.toList());
    }

    public static List<Goal> toEntityList(List<GoalDTO> goalDTOs) {
        return goalDTOs.stream()
                .map(goalDTO -> new Goal(goalDTO.getUserId(), goalDTO.getDescription(), goalDTO.getStatus(), goalDTO.getDifficulty(), goalDTO.getGoalType(), goalDTO.getExp(), goalDTO.getCreateAtDate(), goalDTO.getDueDate()))
                .collect(Collectors.toList());
    }
}
