/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.service.interfaces.users;

import com.wkprojects.affcar.model.SocialToken;

public interface ISocialUserService {
    String authenticateFacebookUser(SocialToken fbToken);

    String authenticateGoogleUser(SocialToken googleToken) throws Exception;
}
