package com.demomasters.lifemasters.controllers;

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
    public ResponseEntity<List<Goal>> getUserGoals(@PathVariable Integer userId) {
        // Probably searching for a user not needed
        User user = userService.findUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByUserId(userId);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<Goal>> getUserGoalsByStatus(@PathVariable Integer userId, @RequestParam String status) {
        User user = userService.findUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByUserIdAndStatus(userId, status);

        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping(params = "difficulty")
    public ResponseEntity<List<Goal>> getUserGoalsByDifficulty(@PathVariable Integer userId, @RequestParam String difficulty) {
        User user = userService.findUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByUserIdAndDifficulty(userId, difficulty);

        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping(params = "goalType")
    public ResponseEntity<List<Goal>> getUserGoalsByGoalType(@PathVariable Integer userId, @RequestParam String goalType) {
        List<Goal> goals = goalService.getGoalsByUserIdAndGoalType(userId, goalType);

        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@PathVariable Integer userId, @RequestBody Goal goal) {
        try {
            User user = userService.findUser(userId);
            Goal createdGoal = goalService.createGoal(user, goal);
            return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{goalId}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Integer goalId, @RequestBody Goal goal) {
        try {
            Goal existingGoal = goalService.getGoalById(goalId);
            if (existingGoal != null) {
                Goal updatedGoal = goalService.updateGoal(goalId, goal);
                return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Goal> deleteGoal(@PathVariable Integer userId, @PathVariable Integer goalId) {
        try {
            Goal existingGoal = goalService.getGoalById(goalId);
            if (existingGoal != null) {
                goalService.deleteGoal(existingGoal.getId());
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
