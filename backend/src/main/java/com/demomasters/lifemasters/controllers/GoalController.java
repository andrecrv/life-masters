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

    @GetMapping("/api/goal/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable int goalId) {
        Goal goal = goalService.getGoalById(goalId);
        if(goal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @GetMapping("/api/goals/{userId}/list")
    public ResponseEntity<List<Goal>> getGoalsByUserId(@PathVariable int userId) {
        User user = userService.getUser(userId);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalByUserId(user);
        if(goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/{userId}/status/{status}")
    public ResponseEntity<List<Goal>> getGoalsByStatus(@PathVariable int userId, @PathVariable String status) {
        User user = userService.getUser(userId);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalByUserId(user);
        if(goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/{userId}/difficulty/{difficulty}")
    public ResponseEntity<List<Goal>> getGoalsByDifficulty(@PathVariable int userId, @PathVariable String difficulty) {
        User user = userService.getUser(userId);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByDifficulty(user, difficulty);
        if(goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/api/goals/{userId}/type/{goalType}")
    public ResponseEntity<List<Goal>> getGoalsByType(@PathVariable int userId, @PathVariable String goalType) {
        User user = userService.getUser(userId);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Goal> goals = goalService.getGoalsByType(user, goalType);
        if(goals.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @PostMapping("/api/goals/{userId}/create-goal")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal, @PathVariable int userId) {
        try {
            User user = userService.getUser(userId);
            Goal createdGoal = goalService.createGoal(user, goal);
            return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/goals/delete-goal/{goalId}")
    public ResponseEntity<Goal> deleteGoal(@PathVariable int goalId) {
        try {
            if(goalService.getGoalById(goalId) != null){
                Goal goal = goalService.getGoalById(goalId);
                goalService.deleteGoal(goalId);
                return new ResponseEntity<>(goal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/goals/update-goal/{goalId}")
    public ResponseEntity<Goal> updateGoal (@PathVariable int goalId, @RequestBody Goal goal) {
        try {
            if(goalService.getGoalById(goalId) != null) {
                Goal newGoal = goalService.updateGoal(goalId, goal);
                return new ResponseEntity<>(newGoal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
