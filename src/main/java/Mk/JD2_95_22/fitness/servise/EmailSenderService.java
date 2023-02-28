package Mk.JD2_95_22.fitness.servise;

import Mk.JD2_95_22.fitness.servise.api.IMailServise;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailSenderService implements IMailServise {
    private JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(SimpleMailMessage mailMessage){
        javaMailSender.send(mailMessage);
    }
}
