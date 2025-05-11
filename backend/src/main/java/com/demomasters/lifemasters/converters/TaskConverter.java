package com.demomasters.lifemasters.converters;

import com.demomasters.lifemasters.dtos.TaskDTO;
import com.demomasters.lifemasters.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskConverter {

    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getUser().getId(), task.getDescription(), task.getStatus(), task.getPriority(), task.getTaskType(), task.getExp(), task.getCreateAtDate(), task.getDueDate());
    }

    public static Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setTaskType(taskDTO.getTaskType());
        task.setExp(taskDTO.getExp());
        task.setCreateAtDate(taskDTO.getCreateAtDate());
        task.setDueDate(taskDTO.getDueDate());
        return task;
    }

    public static List<TaskDTO> toDTOList(List<Task> tasks) {
        return tasks.stream()
                .map(task -> new TaskDTO(task.getId(), task.getUser().getId(), task.getDescription(), task.getStatus(), task.getPriority(), task.getTaskType(), task.getExp(), task.getCreateAtDate(), task.getDueDate()))
                .collect(Collectors.toList());
    }

//    public static List<Task> toEntityList(List<TaskDTO> taskDTOs) {
//        return taskDTOs.stream()
//                .map(taskDTO -> new Task(taskDTO.getUserId(), taskDTO.getDescription(), taskDTO.getStatus(), taskDTO.getPriority(), taskDTO.getTaskType(), taskDTO.getExp(), taskDTO.getCreateAtDate(), taskDTO.getDueDate()))
//                .collect(Collectors.toList());
//    }
}
