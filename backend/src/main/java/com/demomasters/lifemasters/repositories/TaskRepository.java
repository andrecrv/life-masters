package com.demomasters.lifemasters.repositories;

import com.demomasters.lifemasters.models.Task;
import com.demomasters.lifemasters.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByUser(User user);

    List<Task> findByStatusAndUser_Id(String status, int userId);

    List<Task> findByPriorityAndUser_Id(String priority, int userId);

    List<Task> findByTaskTypeAndUser_Id(String taskType, int userId);
}
