/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtToken {
    private String idToken;

    public JwtToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    String getIdToken() {
        return idToken;
    }

    void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
