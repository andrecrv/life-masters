package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.dtos.TaskDTO;
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
    public ResponseEntity<List<TaskDTO>> getUserTasks(@PathVariable Integer userId) {
        List<TaskDTO> taskDTOs = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<TaskDTO>> getUserTasksByStatus(@PathVariable Integer userId, @RequestParam String status) {
        List<TaskDTO> taskDTOs = taskService.getTasksByUserIdAndStatus(userId, status);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "priority")
    public ResponseEntity<List<TaskDTO>> getUserTasksByPriority(@PathVariable Integer userId, @RequestParam String priority) {
        List<TaskDTO> taskDTOs = taskService.getTasksByUserIdAndPriority(userId, priority);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "taskType")
    public ResponseEntity<List<TaskDTO>> getUserTasksByType(@PathVariable Integer userId, @RequestParam String taskType) {
        List<TaskDTO> taskDTOs = taskService.getTasksByUserIdAndTaskType(userId, taskType);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@PathVariable Integer userId, @RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(userId, taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Integer userId, @PathVariable Integer taskId, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(taskId, taskDTO);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer userId, @PathVariable Integer taskId) {
        taskService.deleteTask(userId, taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
