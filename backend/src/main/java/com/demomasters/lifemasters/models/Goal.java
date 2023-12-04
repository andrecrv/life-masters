package com.demomasters.lifemasters.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int goalId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "goal_description")
    private String goalDescription;

    @Column(name = "status")
    private String status;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "goal_type")
    private String goalType;

    @Column(name = "exp")
    private int exp;

    @Column(name = "created_at")
    private Date createAtDate;

    @Column(name = "due_date")
    private Date dueDate;

    /* CONSTRUCTORS */

    public Goal() {

    }

    public Goal(User user, String goalDescription, String status, String difficulty, String goalType, int exp, Date createAtDate, Date dueDate) {
        this.user = user;
        this.goalDescription = goalDescription;
        this.status = status;
        this.difficulty = difficulty;
        this.goalType = goalType;
        this.exp = exp;
        this.createAtDate = createAtDate;
        this.dueDate = dueDate;
    }

    /* GETTERS AND SETTERS */

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
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

    /*TO STRING*/

    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", user=" + user +
                ", goalDescription='" + goalDescription + '\'' +
                ", status='" + status + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", goalType='" + goalType + '\'' +
                ", exp=" + exp +
                ", createAtDate=" + createAtDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
