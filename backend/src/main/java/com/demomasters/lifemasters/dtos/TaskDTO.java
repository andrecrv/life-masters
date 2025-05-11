package com.demomasters.lifemasters.dtos;

import jakarta.persistence.*;

import java.sql.Date;

public class TaskDTO {

//    private Integer id;

    private int userId;

    private String description;

    private String status;

    private String priority;

    private String taskType;

    private int exp;

    private Date createAtDate;

    private Date dueDate;

    public TaskDTO(int userId, String description, String status, String priority, String taskType, int exp, Date createAtDate, Date dueDate) {
        this.userId = userId;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.taskType = taskType;
        this.exp = exp;
        this.createAtDate = createAtDate;
        this.dueDate = dueDate;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Date getCreateAtDate() {
        return createAtDate;
    }

    public void setCreateAtDate(Date createAtDate) {
        this.createAtDate = createAtDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
