package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.models.Task;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.services.TaskService;
import com.demomasters.lifemasters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/users/{userId}/tasks")
public class UserTasksController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable Integer userId) {
        // Probably searching for a user not needed
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByUserId(userId);
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> getUserTasksByStatus(@PathVariable Integer userId, @RequestParam String status) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByUserIdAndStatus(userId, status);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/priority")
    public ResponseEntity<List<Task>> getUserTasksByPriority(@PathVariable Integer userId, @RequestParam String priority) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByUserIdAndPriority(userId, priority);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Task>> getUserTasksByType(@PathVariable Integer userId, @RequestParam String taskType) {
        List<Task> tasks = taskService.getTasksByUserIdAndType(userId, taskType);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable Integer userId, @RequestBody Task task) {
        try {
            User user = userService.getUser(userId);
            Task createdTask = taskService.createTask(user, task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer taskId, @RequestBody Task task) {
        try {
            Task existingTask = taskService.getTaskById(taskId);
            if (existingTask != null) {
                Task updatedTask = taskService.updateTask(taskId, task);
                return new ResponseEntity<>(updatedTask, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer userId, @PathVariable Integer taskId) {
        try {
            Task existingTask = taskService.getTaskById(taskId);
            if (existingTask != null) {
                taskService.deleteTask(existingTask.getId());
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
