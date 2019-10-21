/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends AbstractThrowableProblem {
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistsException(String title) {
        super(ErrorConstants.RESOURCE_ALREADY_Exist_TYPE, title, Status.CONFLICT);
    }
}
