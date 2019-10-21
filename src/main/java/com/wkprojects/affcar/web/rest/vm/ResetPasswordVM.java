/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.vm;

import javax.validation.constraints.NotEmpty;

public class ResetPasswordVM {

    @NotEmpty
    String resetKey;

    @NotEmpty
    String newPassword;

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ResetPasswordVM{" +
                "resetKey='" + resetKey + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
