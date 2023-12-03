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

    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public List<Task> getTasksByUserId(User user) {
        return taskRepository.findByUser(user);
    }

    public List<Task> getTasksByStatus(User user, String status) {
        return taskRepository.findByStatusAndUser_Id(status, user.getId());
    }

    public List<Task> getTasksByPriority(User user, String priority) {
        return taskRepository.findByPriorityAndUser_Id(priority, user.getId());
    }

    public List<Task> getTasksByType(User user, String taskType) {
        return taskRepository.findByTaskTypeAndUser_Id(taskType, user.getId());
    }

    public Task createTask (User user, Task task){
        Task mockTask = new Task(user, task.getTaskDescription(), task.getStatus(), task.getPriority(), task.getTaskType(), task.getExp(), task.getCreateAtDate(), task.getDueDate());
        Task newTask = taskRepository.save(mockTask);
        return newTask;
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(int taskId, Task task){
        Task existingTask = getTaskById(taskId);
        if(existingTask == null) {
            return null;
        }
        existingTask.setTaskDescription(task.getTaskDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setTaskType(task.getTaskType());
        existingTask.setExp(task.getExp());
        existingTask.setCreateAtDate(task.getCreateAtDate());
        existingTask.setDueDate(task.getDueDate());

        return taskRepository.save(existingTask);
    }

}
