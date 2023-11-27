package com.demomasters.lifemasters.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column
    private String username;
    @Column
    private String passwd;
    @Column
    private String email;
    @Column
    private int lvl;
    @Column
    private String title;

    public User() {

    }

    public User(String username, String passwd, String email, int lvl, String title) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.lvl = lvl;
        this.title = title;
    }

    public int getId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
