package com.shaw.springbootlogin.model;

import javax.validation.constraints.NotEmpty;

public class UserCreateForm {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordRepeat;

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

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
