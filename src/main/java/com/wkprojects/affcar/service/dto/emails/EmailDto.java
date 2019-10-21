/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.service.dto.emails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class EmailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String from;

    @NotBlank(message = "Field \"to\" can't be blank")
    private String to;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cc;

    @NotBlank(message = "Field \"subject\" can't be blank")
    @Size(max = 255, message = "The size of the email subject must not exceed 255 characters.")
    private String subject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String textPart;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String htmlPart;

    private String senderName;

    @JsonIgnore
    private Integer numberOfAttempts;

    @JsonIgnore
    private Boolean status;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextPart() {
        return textPart;
    }

    public void setTextPart(String textPart) {
        this.textPart = textPart;
    }

    public String getHtmlPart() {
        return htmlPart;
    }

    public void setHtmlPart(String htmlPart) {
        this.htmlPart = htmlPart;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                ", subject='" + subject + '\'' +
                ", textPart='" + textPart + '\'' +
                ", htmlPart='" + htmlPart + '\'' +
                ", senderName='" + senderName + '\'' +
                ", numberOfAttempts=" + numberOfAttempts +
                ", status=" + status +
                '}';
    }
}
