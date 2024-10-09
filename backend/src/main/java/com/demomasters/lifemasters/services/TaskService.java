package com.demomasters.lifemasters.services;

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

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getTasksByType(String taskType) {
        return taskRepository.findByTaskType(taskType);
    }

    public List<Task> getTasksByUserIdAndStatus(Integer userId, String status) {
        return taskRepository.findByUserAndStatus(userId, status);
    }

    public List<Task> getTasksByUserIdAndPriority(Integer userId, String priority) {
        return taskRepository.findByUserAndPriority(userId, priority);
    }

    public List<Task> getTasksByUserIdAndType(Integer userId, String taskType) {
        return taskRepository.findByUserAndTaskType(userId, taskType);
    }

    public Task createTask(User user, Task task) {
        Task mockTask = new Task(user, task.getDescription(), task.getStatus(), task.getPriority(), task.getTaskType(), task.getExp(), task.getCreateAtDate(), task.getDueDate());
        Task newTask = taskRepository.save(mockTask);
        return newTask;
    }

    public Task updateTask(Integer id, Task task) {
        Task existingTask = getTaskById(id);

        if (existingTask == null) {
            return null;
        }
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setTaskType(task.getTaskType());
        existingTask.setExp(task.getExp());
        existingTask.setCreateAtDate(task.getCreateAtDate());
        existingTask.setDueDate(task.getDueDate());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
