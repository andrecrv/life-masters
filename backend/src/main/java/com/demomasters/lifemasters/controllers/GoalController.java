package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.dtos.GoalDTO;
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
    public ResponseEntity<List<GoalDTO>> getGoals() {
        return new ResponseEntity<>(goalService.getGoals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalDTO> getGoalById(@PathVariable int id) {
        GoalDTO goalDTO = goalService.getGoalById(id);
        return new ResponseEntity<>(goalDTO, HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<GoalDTO>> getGoalsByStatus(@RequestParam String status) {
        List<GoalDTO> goalDTOs = goalService.getGoalsByStatus(status);
        return new ResponseEntity<>(goalDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "difficulty")
    public ResponseEntity<List<GoalDTO>> getGoalsByDifficulty(@RequestParam String difficulty) {
        List<GoalDTO> goals = goalService.getGoalsByDifficulty(difficulty);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping(params = "goalType")
    public ResponseEntity<List<GoalDTO>> getGoalsByGoalType(@RequestParam String goalType) {
        List<GoalDTO> goalDTOs = goalService.getGoalsByGoalType(goalType);
        return new ResponseEntity<>(goalDTOs, HttpStatus.OK);
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
    public ResponseEntity<Goal> updateGoal(@PathVariable int id, @RequestBody Goal goal) {
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
    public ResponseEntity<Goal> deleteGoal(@PathVariable int id) {
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
