/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.errors;

import java.net.URI;

public class ErrorConstants {

    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "https://www.your_url/problem";
    public static final URI INTERNAL_PROBLEM = URI.create("/internal-problem");
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");
    public static final URI PARAMETERIZED_TYPE = URI.create(PROBLEM_BASE_URL + "/parameterized");
    public static final URI ENTITY_NOT_FOUND_TYPE = URI.create(PROBLEM_BASE_URL + "/entity-not-found");
    public static final URI INVALID_PASSWORD_TYPE = URI.create(PROBLEM_BASE_URL + "/invalid-password");
    public static final URI EMAIL_ALREADY_USED_TYPE = URI.create(PROBLEM_BASE_URL + "/email-already-used");
    public static final URI LOGIN_ALREADY_USED_TYPE = URI.create(PROBLEM_BASE_URL + "/login-already-used");
    public static final URI EMAIL_NOT_FOUND_TYPE = URI.create(PROBLEM_BASE_URL + "/email-not-found");
    public static final URI FORMAT_NOT_VALID_TYPE = URI.create(PROBLEM_BASE_URL + "/format-not-valid");
    public static final URI RESOURCE_NOT_FOUND_TYPE = URI.create(PROBLEM_BASE_URL + "/resource-not-found");
    public static final URI RESOURCE_ALREADY_Exist_TYPE = URI.create(PROBLEM_BASE_URL + "/resource-already-exist");
    public static final URI RESOURCE_ALREADY_ASSIGNED_TYPE = URI.create(PROBLEM_BASE_URL + "/resource-assigned");
    private ErrorConstants() {
    }
}
