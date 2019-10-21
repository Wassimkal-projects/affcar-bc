/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.service.implementation.users;

import com.google.gson.Gson;
import com.wkprojects.affcar.domain.users.Authority;
import com.wkprojects.affcar.domain.users.User;
import com.wkprojects.affcar.model.SocialToken;
import com.wkprojects.affcar.model.SocialUserModel;
import com.wkprojects.affcar.repository.users.UserRepository;
import com.wkprojects.affcar.security.AuthoritiesConstants;
import com.wkprojects.affcar.security.jwt.TokenProvider;
import com.wkprojects.affcar.service.interfaces.users.ISocialUserService;
import com.wkprojects.affcar.utils.GoogleApiUtils;
import com.wkprojects.affcar.utils.RandomUtil;
import com.wkprojects.affcar.web.rest.errors.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class SocialUserServiceImpl implements ISocialUserService {
    private static final Logger logger = LogManager.getLogger(SocialUserServiceImpl.class);
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private Gson gson = new Gson();

    public SocialUserServiceImpl(UserRepository userRepository, TokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String authenticateFacebookUser(SocialToken fbToken) {
        logger.info("token: {}", fbToken.getAccessToken());
        Facebook facebook = new FacebookTemplate(fbToken.getAccessToken());
        String[] fields = {"id", "name", "email", "first_name", "last_name"};
//        String[] fieldsTest = {"id", "about", "age_range", "birthday", "cover", "currency", "devices", "education", "email", "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown", "inspirational_people", "installed", "install_type", "is_verified", "languages", "last_name", "link", "locale", "location", "meeting_for", "middle_name", "name", "name_format", "political", "quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other", "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "video_upload_limits", "viewer_can_send_gift", "website", "work"};
//        logger.info(facebook.fetchObject("me", String.class, fieldsTest).toString());
        //{ "id", "about", "age_range", "birthday", "context", "cover", "currency", "devices", "education", "email", "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown", "inspirational_people", "installed", "install_type", "is_verified", "languages", "last_name", "link", "locale", "location", "meeting_for", "middle_name", "name", "name_format", "political", "quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other", "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "video_upload_limits", "viewer_can_send_gift", "website", "work"}
        SocialUserModel facebookUser = gson.fromJson(facebook.fetchObject("me", String.class, fields), SocialUserModel.class);
        return authenticateSocialUser(facebookUser);
    }

    @Override
    public String authenticateGoogleUser(SocialToken googleToken) throws GeneralSecurityException, IOException {
        SocialUserModel googleUser = GoogleApiUtils.checkIfGoogleTokenIsValid(googleToken.getAccessToken()).orElseThrow(
                () -> new BadRequestException("Google Authenticaiton failded, Token not valid")
        );
        return authenticateSocialUser(googleUser);
    }

    private String authenticateSocialUser(SocialUserModel socialUser) {
        logger.info("socialUser: {}", socialUser.toString());
        Optional<User> user = userRepository.findOneByEmail(socialUser.getEmail());
        if (!user.isPresent()) {
            Set<Authority> authorities = new HashSet<>();
            Authority authority = new Authority();
            authority.setName(AuthoritiesConstants.USER);
            authorities.add(authority);

            User userAccount = new User();
            userAccount.setAuthorities(authorities);
            userAccount.setEmail(socialUser.getEmail());
            userAccount.setImageUrl(socialUser.getPictureUrl());
            userAccount.setPassword(passwordEncoder.encode(RandomUtil.generatePassword()));
            userAccount.setActivated(true);
            user = Optional.of(userRepository.save(userAccount));
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.get().getEmail(), null,
                AuthorityUtils.createAuthorityList(user.get().getAuthorities().stream().map(Authority::getName).collect(Collectors.toList()).toString()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.createToken(authentication, false);
    }
}
