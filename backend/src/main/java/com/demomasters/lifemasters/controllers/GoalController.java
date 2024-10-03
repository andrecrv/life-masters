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
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/goals")
    public ResponseEntity<List<Goal>> getGoals() {
        return new ResponseEntity<List<Goal>>(goalService.getAllGoals(), HttpStatus.OK);
    }

    @GetMapping("/api/goal/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Integer id) {
        Goal goal = goalService.getGoalById(id);
        if (goal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @GetMapping("/api/goals/user/{userId}/")
    public ResponseEntity<List<Goal>> getGoalsByUserId(@PathVariable Integer userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalByUserId(user);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/user/{userId}/status/{status}")
    public ResponseEntity<List<Goal>> getGoalsByStatus(@PathVariable Integer userId, @PathVariable String status) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalByUserId(user);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/user/{userId}/difficulty/{difficulty}")
    public ResponseEntity<List<Goal>> getGoalsByDifficulty(@PathVariable Integer userId, @PathVariable String difficulty) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByDifficulty(user, difficulty);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/user/{userId}/type/{goalType}")
    public ResponseEntity<List<Goal>> getGoalsByType(@PathVariable Integer userId, @PathVariable String goalType) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByType(user, goalType);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @PostMapping("/api/goals/user/{userId}/create-goal")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal, @PathVariable Integer userId) {
        try {
            User user = userService.getUser(userId);
            Goal createdGoal = goalService.createGoal(user, goal);
            return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/goals/delete-goal/{id}")
    public ResponseEntity<Goal> deleteGoal(@PathVariable Integer id) {
        try {
            Goal existingGoal = goalService.getGoalById(id);
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

    @PutMapping("/api/goals/update-goal/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Integer id, @RequestBody Goal goal) {
        try {
            Goal existingGoal = goalService.getGoalById(id);
            if (existingGoal != null) {
                Goal updatedGoal = goalService.updateGoal(id, goal);
                return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
