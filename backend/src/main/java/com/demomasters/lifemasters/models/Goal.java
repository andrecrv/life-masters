package com.demomasters.lifemasters.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "description")
    private String description;

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

    public Goal(User user, String description, String status, String difficulty, String goalType, int exp, Date createAtDate, Date dueDate) {
        this.user = user;
        this.description = description;
        this.status = status;
        this.difficulty = difficulty;
        this.goalType = goalType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    /*TO STRING*/

    @Override
    public String toString() {
        return "Goal {" +
                "goalId=" + id +
                ", user=" + user +
                ", goalDescription='" + description + '\'' +
                ", status='" + status + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", goalType='" + goalType + '\'' +
                ", exp=" + exp +
                ", createAtDate=" + createAtDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
