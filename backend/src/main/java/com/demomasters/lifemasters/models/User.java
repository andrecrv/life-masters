package com.demomasters.lifemasters.models;

public class User {

    private int userId;
    private String username;
    private String password;
    private String email;
    private int level;
    private String title;

    public User(int userId, String username, String password, String email, int level) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.level = level;
    }

    public int getId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
