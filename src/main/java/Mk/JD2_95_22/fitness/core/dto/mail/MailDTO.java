package Mk.JD2_95_22.fitness.core.dto.mail;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
import jakarta.validation.constraints.NotBlank;

public class MailDTO {

    @ValidMail
    @ValidString
    private String to;
    @ValidString
    private String subject;
    @ValidString
    private String message;

    public MailDTO(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
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

    public String getText() {
        return message;
    }

    public void setText(String message) {
        this.message = message;
    }
}
