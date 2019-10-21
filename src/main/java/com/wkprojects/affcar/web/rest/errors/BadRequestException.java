/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends AbstractThrowableProblem {
    private static final long serialVersionUID = 1L;

    public BadRequestException(String title) {
        super(ErrorConstants.RESOURCE_NOT_FOUND_TYPE, title, Status.CONFLICT);
    }
}
