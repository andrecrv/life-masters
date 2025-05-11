package com.demomasters.lifemasters.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    @Column(name = "task_type")
    private String taskType;

    @Column(name = "exp")
    private int exp;

    @Column(name = "created_at")
    private Date createAtDate;

    @Column(name = "due_date")
    private Date dueDate;


    /* CONSTRUCTORS */

    public Task() {

    }

    public Task(Integer userId, String description, String status, String priority, String taskType, int exp, Date createAtDate, Date dueDate) {
        this.userId = userId;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.taskType = taskType;
        this.exp = exp;
        this.createAtDate = createAtDate;
        this.dueDate = dueDate;
    }

    /* GETTERS AND SETTERS */

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

    /*TO STRING*/

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", userId=" + userId +
                ", taskDescription='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", taskType='" + taskType + '\'' +
                ", exp=" + exp +
                ", createAtDate=" + createAtDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
