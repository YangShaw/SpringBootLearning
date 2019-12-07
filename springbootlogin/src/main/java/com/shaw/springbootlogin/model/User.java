package com.shaw.springbootlogin.model;


import javax.persistence.*;


@Entity
@Table(name = "t_user")
public class User {

    //  标明主键，并且自动生成
    @Id
    @Column(name = "user_name")
    private String userName;
    @Column
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                " userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
