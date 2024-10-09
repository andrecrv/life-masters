package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByUserId(Integer userId);

    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByTaskType(String taskType);

    List<Task> findByUserAndStatus(Integer userId, String status);

    List<Task> findByUserAndPriority(Integer userId, String priority);

    List<Task> findByUserAndTaskType(Integer userId, String taskType);
}
