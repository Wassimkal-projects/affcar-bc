/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.users;

import com.wkprojects.affcar.model.SocialToken;
import com.wkprojects.affcar.model.JwtToken;
import com.wkprojects.affcar.service.interfaces.users.ISocialUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social")
@CrossOrigin
public class SocialUserResource {

    private final AuthenticationManager authenticationManager;
    private final ISocialUserService facebookUserService;

    public SocialUserResource(AuthenticationManager authenticationManager, ISocialUserService facebookUserService) {
        this.authenticationManager = authenticationManager;
        this.facebookUserService = facebookUserService;
    }

    @PostMapping("/fb-auth")
    public ResponseEntity authenticateFacebookUser(@RequestBody SocialToken fbToken) {
        String jwt = facebookUserService.authenticateFacebookUser(fbToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/google-auth")
    public ResponseEntity authenticateGoogleUser(@RequestBody SocialToken googleToken) throws Exception {
        String jwt = facebookUserService.authenticateGoogleUser(googleToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }

}
