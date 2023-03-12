package Mk.JD2_95_22.fitness.servise.my_exeption.mail;

import org.springframework.mail.MailSendException;

public class MailNotFoundExeption extends RuntimeException{
    public MailNotFoundExeption(){};
    public MailNotFoundExeption(String message) {
        super(message);
    }
}
