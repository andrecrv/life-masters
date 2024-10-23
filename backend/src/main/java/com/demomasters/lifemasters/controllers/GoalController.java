package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.models.Goal;
import com.demomasters.lifemasters.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public ResponseEntity<List<Goal>> getGoals() {
        return new ResponseEntity<List<Goal>>(goalService.getGoals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Integer id) {
        Goal goal = goalService.getGoalById(id);
        if (goal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Goal>> getGoalsByStatus(@RequestParam String status) {
        List<Goal> goals = goalService.getGoalsByStatus(status);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/difficulty")
    public ResponseEntity<List<Goal>> getGoalsByDifficulty(@RequestParam String difficulty) {
        List<Goal> goals = goalService.getGoalsByDifficulty(difficulty);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Goal>> getGoalsByType(@RequestParam String goalType) {
        List<Goal> goals = goalService.getGoalsByType(goalType);
        if (goals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    /* Not used for now
    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        try {
            Goal createdGoal = goalService.createGoal(goal);
            return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
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

     */
}
