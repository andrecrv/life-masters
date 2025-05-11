package com.demomasters.lifemasters.services;

import com.demomasters.lifemasters.converters.TaskConverter;
import com.demomasters.lifemasters.dtos.TaskDTO;
import com.demomasters.lifemasters.exceptions.TaskNotFoundException;
import com.demomasters.lifemasters.exceptions.UnauthorizedAccessException;
import com.demomasters.lifemasters.exceptions.UserNotFoundException;
import com.demomasters.lifemasters.models.Task;
import com.demomasters.lifemasters.models.User;
import com.demomasters.lifemasters.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return TaskConverter.toDTOList(tasks);
    }

    public TaskDTO getTaskById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
        return TaskConverter.toDTO(task);
    }

    public List<TaskDTO> getTasksByUserId(Integer userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByStatus(String status) {
        List<Task> tasks = taskRepository.findByStatus(status);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByPriority(String priority) {
        List<Task> tasks = taskRepository.findByPriority(priority);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByTaskType(String taskType) {
        List<Task> tasks = taskRepository.findByTaskType(taskType);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByUserIdAndStatus(Integer userId, String status) {
        List<Task> tasks = taskRepository.findByUserIdAndStatus(userId, status);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByUserIdAndPriority(Integer userId, String priority) {
        List<Task> tasks = taskRepository.findByUserIdAndPriority(userId, priority);
        return TaskConverter.toDTOList(tasks);
    }

    public List<TaskDTO> getTasksByUserIdAndTaskType(Integer userId, String taskType) {
        List<Task> tasks = taskRepository.findByUserIdAndTaskType(userId, taskType);
        return TaskConverter.toDTOList(tasks);
    }

    public TaskDTO createTask(Integer userId, TaskDTO taskDTO) {
        // TODO: Add validations
        Task newTask = TaskConverter.toEntity(taskDTO);
        newTask.setUserId(userId);

        Task createdTask = taskRepository.save(newTask);
        return TaskConverter.toDTO(createdTask);
    }

    public TaskDTO updateTask(Integer id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        if (taskDTO.getDescription() != null && !taskDTO.getDescription().isBlank()) {
            task.setDescription(taskDTO.getDescription());
        }
        if (taskDTO.getStatus() != null && !taskDTO.getStatus().isBlank()) {
            task.setStatus(taskDTO.getStatus());
        }
        if (taskDTO.getPriority() != null && !taskDTO.getPriority().isBlank()) {
            task.setPriority(taskDTO.getPriority());
        }
        if (taskDTO.getTaskType() != null && !taskDTO.getTaskType().isBlank()) {
            task.setTaskType(taskDTO.getTaskType());
        }

//        task.setExp(taskDTO.getExp());
//        task.setCreateAtDate(taskDTO.getCreateAtDate());
//        task.setDueDate(taskDTO.getDueDate());

        Task updatedTask = taskRepository.save(task);
        return TaskConverter.toDTO(updatedTask);
    }

    public void deleteTask(Integer userId, Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        if (task.getUserId() != userId) {
            throw new UnauthorizedAccessException("User " + userId + " does not own this task");
        }

        taskRepository.delete(task);
    }
}
