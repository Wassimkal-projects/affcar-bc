/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.wkprojects.affcar.model.SocialUserModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

public class GoogleApiUtils {

    private static final String CLIENT_ID = "196194089193-3ks6sacirmdorvbmsra2o43t745hdbtd.apps.googleusercontent.com";

    public static Optional<SocialUserModel> checkIfGoogleTokenIsValid(String idTokenString) throws GeneralSecurityException, IOException {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            SocialUserModel googleUserModel = new SocialUserModel();
            googleUserModel.setEmail(payload.getEmail());
            googleUserModel.setName((String) payload.get("name"));
            googleUserModel.setFirstName((String) payload.get("given_name"));
            googleUserModel.setLastName((String) payload.get("family_name"));
            googleUserModel.setPictureUrl((String) payload.get("picture"));

/*            googleUserModel.setUserId(payload.getSubject());
            googleUserModel.setLocale((String) payload.get("locale"));
            googleUserModel.setFamilyName((String) payload.get("family_name"));
            googleUserModel.setGivenName((String) payload.get("given_name"));
            googleUserModel.setEmailVerified(payload.getEmailVerified());*/

            return Optional.of(googleUserModel);

        } else {
            return Optional.empty();
        }
    }
}
