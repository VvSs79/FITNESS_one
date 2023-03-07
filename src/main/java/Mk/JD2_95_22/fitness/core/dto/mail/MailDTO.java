package Mk.JD2_95_22.fitness.core.dto.mail;


public class MailDTO {
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String mailContent;

    public MailDTO() {
    }

    public MailDTO(String emailFrom, String emailTo, String subject, String mailContent) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.mailContent = mailContent;
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

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
