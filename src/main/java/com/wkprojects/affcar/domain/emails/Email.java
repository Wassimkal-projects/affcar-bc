/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.domain.emails;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "emails")
public class Email implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    @SequenceGenerator(name = "email_seq", sequenceName = "email_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "sender")
    private String from;

    @Column(name = "receiver")
    private String to;

    @Column(name = "cc")
    private String cc;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content_text")
    private String textPart;

    @Column(name = "content_html")
    private String htmlPart;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "number_of_attempts")
    private Integer numberOfAttempts;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createDateTime;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updateDateTime;

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
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
        return "Email{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                ", subject='" + subject + '\'' +
                ", textPart='" + textPart + '\'' +
                ", htmlPart='" + htmlPart + '\'' +
                ", senderName='" + senderName + '\'' +
                ", status=" + status +
                ", numberOfAttempts=" + numberOfAttempts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(getId(), email.getId()) &&
                Objects.equals(getFrom(), email.getFrom()) &&
                Objects.equals(getTo(), email.getTo()) &&
                Objects.equals(getCc(), email.getCc()) &&
                Objects.equals(getSubject(), email.getSubject()) &&
                Objects.equals(getTextPart(), email.getTextPart()) &&
                Objects.equals(getHtmlPart(), email.getHtmlPart()) &&
                Objects.equals(getSenderName(), email.getSenderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getCc(), getSubject(), getTextPart(), getHtmlPart(), getSenderName(), getStatus(), getNumberOfAttempts());
    }
}
