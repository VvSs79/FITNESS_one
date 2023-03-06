package Mk.JD2_95_22.fitness.core.dto.mail;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import java.util.Objects;
import java.util.UUID;

public class MailDTO {
    private String emailFrom;
    private String emailTo;
    private String subject;
    private UUID message;

    public MailDTO() {
    }

    public MailDTO(String emailFrom, String emailTo, String subject, UUID message) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.message = message;
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
}
