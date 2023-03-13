package Mk.JD2_95_22.fitness.servise.my_exeption.mail;

import org.springframework.mail.MailSendException;

import java.util.Map;

public class SendMailExeption  extends MailSendException {
    public SendMailExeption(String message) {
        super(message);
    }

    public SendMailExeption(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SendMailExeption(String msg, Throwable cause, Map<Object, Exception> failedMessages) {
        super(msg, cause, failedMessages);
    }

    public SendMailExeption(Map<Object, Exception> failedMessages) {
        super(failedMessages);
    }
}
