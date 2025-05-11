package com.demomasters.lifemasters.dtos;

import jakarta.persistence.*;

import java.sql.Date;

public class GoalDTO {

    private Integer id;

    private Integer userId;

    private String description;

    private String status;

    private String difficulty;

    private String goalType;

    private Integer exp;

    private Date createAtDate;

    private Date dueDate;

    public GoalDTO(Integer id, Integer userId, String description, String status, String difficulty, String goalType, Integer exp, Date createAtDate, Date dueDate) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.status = status;
        this.difficulty = difficulty;
        this.goalType = goalType;
        this.exp = exp;
        this.createAtDate = createAtDate;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
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
