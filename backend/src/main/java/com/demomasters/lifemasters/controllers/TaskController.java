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
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Integer userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByUserId(user);
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{userId}/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable Integer userId, @PathVariable String status) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByStatus(user, status);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{userId}/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable Integer userId, @PathVariable String priority) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByPriority(user, priority);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{userId}/type/{taskType}")
    public ResponseEntity<List<Task>> getTasksByType(@PathVariable Integer userId, @PathVariable String taskType) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByType(user, taskType);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Integer userId, @RequestBody Task task) {
        try {
            User user = userService.getUser(userId);
            Task createdTask = taskService.createTask(user, task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        try {
            Task existingTask = taskService.getTaskById(id);
            if (existingTask != null) {
                Task updatedTask = taskService.updateTask(id, task);
                return new ResponseEntity<>(updatedTask, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
        try {
            Task existingTask = taskService.getTaskById(id);
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
