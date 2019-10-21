/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalProblemException extends AbstractThrowableProblem {
    private static final long serialVersionUID = 1L;

    public InternalProblemException(String title) {
        super(ErrorConstants.INTERNAL_PROBLEM, title, Status.INTERNAL_SERVER_ERROR);
    }
}
