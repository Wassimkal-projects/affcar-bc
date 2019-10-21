/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotNull
    @Size(min = 1, max = 50)
    @Email
    private String email;

    @NotNull
    private String password;

    private Boolean rememberMe;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
