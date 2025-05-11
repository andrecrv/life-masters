package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.dtos.GoalDTO;
import com.demomasters.lifemasters.models.Goal;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.services.GoalService;
import com.demomasters.lifemasters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/users/{userId}/goals")
public class UserGoalsController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

    @GetMapping
    public ResponseEntity<List<GoalDTO>> getUserGoals(@PathVariable Integer userId) {
        List<GoalDTO> goalDTOs = goalService.getGoalsByUserId(userId);
        return new ResponseEntity<>(goalDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<GoalDTO>> getUserGoalsByStatus(@PathVariable Integer userId, @RequestParam String status) {
        List<GoalDTO> goals = goalService.getGoalsByUserIdAndStatus(userId, status);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping(params = "difficulty")
    public ResponseEntity<List<GoalDTO>> getUserGoalsByDifficulty(@PathVariable Integer userId, @RequestParam String difficulty) {
        List<GoalDTO> goalDTOs = goalService.getGoalsByUserIdAndDifficulty(userId, difficulty);
        return new ResponseEntity<>(goalDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "goalType")
    public ResponseEntity<List<GoalDTO>> getUserGoalsByGoalType(@PathVariable Integer userId, @RequestParam String goalType) {
        List<GoalDTO> goalDTOs = goalService.getGoalsByUserIdAndGoalType(userId, goalType);
        return new ResponseEntity<>(goalDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoalDTO> createGoal(@PathVariable Integer userId, @RequestBody GoalDTO goalDTO) {
        GoalDTO createdGoal = goalService.createGoal(userId, goalDTO);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);

    }

    @PatchMapping("/{goalId}")
    public ResponseEntity<GoalDTO> updateGoal(@PathVariable Integer userId, @PathVariable Integer goalId, @RequestBody GoalDTO goalDTO) {
        GoalDTO updatedGoal = goalService.updateGoal(goalId, goalDTO);
        return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Integer userId, @PathVariable Integer goalId) {
        goalService.deleteGoal(userId, goalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
