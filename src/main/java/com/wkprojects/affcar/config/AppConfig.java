/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.config;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import com.wkprojects.affcar.constants.MailjetConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public MailjetClient mailjetClient() {
        return new MailjetClient(MailjetConstants.MJ_APIKEY_PUBLIC, MailjetConstants.MJ_APIKEY_PRIVATE, new ClientOptions("v3.1"));
    }

    @Bean
    public MailjetRequest mailjetRequest() {
        return new MailjetRequest(Emailv31.resource);
    }

    @Bean
    public MailjetResponse mailjetResponse() {
        return new MailjetResponse(null);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
