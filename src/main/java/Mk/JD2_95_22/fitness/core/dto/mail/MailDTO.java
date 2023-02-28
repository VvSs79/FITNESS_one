package Mk.JD2_95_22.fitness.core.dto.mail;

import Mk.JD2_95_22.fitness.core.dto.user.User;
import java.util.Objects;
import java.util.UUID;

public class MailDTO {
    private String emailFrom;
    private String emailTo;
    private String subject;
    private UUID message;
    private  User user;


    public MailDTO(String emailFrom, String emailTo, String subject, String message) {
        this.emailFrom = emailFrom;
        this.emailTo = user.getMail();
        this.subject ="complete registration, click to link";
        this.message =user.getEssence().getUuid();
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UUID getMessage() {
        return message;
    }

    public void setMessage(UUID message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailDTO mailDTO = (MailDTO) o;
        return Objects.equals(emailFrom, mailDTO.emailFrom) && Objects.equals(emailTo, mailDTO.emailTo) && Objects.equals(subject, mailDTO.subject) && Objects.equals(message, mailDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailFrom, emailTo, subject, message);
    }

    @Override
    public String toString() {
        return "mailDTO{" +
                "emailFrom='" + emailFrom + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", message=" + message +
                '}';
    }
}
