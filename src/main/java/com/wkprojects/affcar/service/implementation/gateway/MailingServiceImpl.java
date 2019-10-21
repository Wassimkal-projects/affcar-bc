/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.service.implementation.gateway;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import com.wkprojects.affcar.constants.AffcarConstants;
import com.wkprojects.affcar.constants.MailjetConstants;
import com.wkprojects.affcar.domain.users.User;
import com.wkprojects.affcar.service.implementation.users.SocialUserServiceImpl;
import com.wkprojects.affcar.service.interfaces.gateway.IMailingService;
import com.wkprojects.affcar.web.rest.errors.InternalProblemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@Transactional
public class MailingServiceImpl implements IMailingService {

    private static final Logger logger = LogManager.getLogger(SocialUserServiceImpl.class);

    private final MailjetClient mailjetClient;
    private final SpringTemplateEngine templateEngine;
    private MailjetRequest mailjetRequestEmail;

    public MailingServiceImpl(MailjetClient mailjetClient, MailjetRequest mailjetRequestEmail, SpringTemplateEngine templateEngine) {
        this.mailjetClient = mailjetClient;
        this.mailjetRequestEmail = mailjetRequestEmail;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendActivationEmail(User user) {
        logger.debug("sending activation email to :" + user.getEmail());
        JSONObject message = new JSONObject();

        Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("baseUrl", AffcarConstants.BASE_URL);
        String content = templateEngine.process(AffcarConstants.EMAIL_TEMPLATE_NAME, context);

        message.put(Emailv31.Message.FROM, new JSONObject()
                .put(Emailv31.Message.EMAIL, MailjetConstants.SENDER_EMAIL)
                .put(Emailv31.Message.NAME, AffcarConstants.ACTIVATION_EMAIL_SENDER_NAME)
        )
                .put(Emailv31.Message.SUBJECT, AffcarConstants.ACTIVATION_EMAIL_SUBJECT)
                .put(Emailv31.Message.HTMLPART, content)
                .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject().put(Emailv31.Message.EMAIL, user.getEmail())));


        mailjetRequestEmail.property(Emailv31.MESSAGES, (new JSONArray()).put(message));

        try {
            mailjetClient.post(mailjetRequestEmail);
        } catch (MailjetException e) {
            throw new InternalProblemException("Internal Problem");
        } catch (MailjetSocketTimeoutException e) {
            e.printStackTrace();
        }
    }
}
