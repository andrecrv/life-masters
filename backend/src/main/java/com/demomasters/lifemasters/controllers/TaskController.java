package com.demomasters.lifemasters.controllers;

import com.demomasters.lifemasters.dtos.TaskDTO;
import com.demomasters.lifemasters.models.Task;
import com.demomasters.lifemasters.services.TaskService;
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

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<TaskDTO>> getTasksByStatus(@RequestParam String status) {
        List<TaskDTO> taskDTOs = taskService.getTasksByStatus(status);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "priority")
    public ResponseEntity<List<TaskDTO>> getTasksByPriority(@RequestParam String priority) {
        List<TaskDTO> taskDTOs = taskService.getTasksByPriority(priority);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping(params = "taskType")
    public ResponseEntity<List<TaskDTO>> getTasksByType(@RequestParam String taskType) {
        List<TaskDTO> taskDTOs = taskService.getTasksByTaskType(taskType);
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    /* Not used for now
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        try {
            Task createdTask = taskService.createTask(task);
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

     */
}
