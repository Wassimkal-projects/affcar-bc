/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.service.interfaces.gateway;

import com.wkprojects.affcar.domain.users.User;

public interface IMailingService {

    void sendActivationEmail(User user);
}
