package com.demomasters.lifemasters.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "task_description")
    private String taskDescription;

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

    public Task(User user, String taskDescription, String status, String priority, String taskType, int exp, Date createAtDate, Date dueDate) {
        this.user = user;
        this.taskDescription = taskDescription;
        this.status = status;
        this.priority = priority;
        this.taskType = taskType;
        this.exp = exp;
        this.createAtDate = createAtDate;
        this.dueDate = dueDate;
    }

    /* GETTERS AND SETTERS */

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    /*TO STRING*/

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", user=" + user +
                ", taskDescription='" + taskDescription + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", taskType='" + taskType + '\'' +
                ", exp=" + exp +
                ", createAtDate=" + createAtDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
