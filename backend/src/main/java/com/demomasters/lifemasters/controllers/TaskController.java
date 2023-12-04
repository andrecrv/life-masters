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
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/api/task/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId){
        Task task= taskService.getTaskById(taskId);
        if(task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @GetMapping("/api/tasks/{userId}/list")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable int userId){
        User user = userService.getUser(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByUserId(user);
        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/api/tasks/{userId}/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable int userId, @PathVariable String status) {
        User user = userService.getUser(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Task> tasks = taskService.getTasksByStatus(user, status);

        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/api/tasks/{userId}/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable int userId, @PathVariable String priority) {
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

    @GetMapping("/api/tasks/{userId}/type/{taskType}")
    public ResponseEntity<List<Task>> getTasksByType(@PathVariable int userId, @PathVariable String taskType) {
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

    @PostMapping("/api/tasks/{userId}/create-task")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @PathVariable int userId) {
        try {
            User user = userService.getUser(userId);
            Task createdTask = taskService.createTask(user, task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/tasks/delete-task/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable int taskId){
        try {
            if(taskService.getTaskById(taskId) != null) {
                Task task = taskService.getTaskById(taskId);
                taskService.deleteTask(taskId);
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/tasks/update-task/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody Task task){
        try {
            if(taskService.getTaskById(taskId) != null) {
                Task newTask = taskService.updateTask(taskId, task);
                return new ResponseEntity<>(newTask, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
