package com.demomasters.lifemasters.dtos;

import java.sql.Date;

public class GoalDTO {

    private int id;

    private int userId;

    private String description;

    private String status;

    private String difficulty;

    private String goalType;

    private int exp;

    private Date createAtDate;

    private Date dueDate;

    public GoalDTO(int id, int userId, String description, String status, String difficulty, String goalType, int exp, Date createAtDate, Date dueDate) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
