/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends AbstractThrowableProblem {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String title) {
        super(ErrorConstants.RESOURCE_NOT_FOUND_TYPE, title, Status.CONFLICT);
    }
}
