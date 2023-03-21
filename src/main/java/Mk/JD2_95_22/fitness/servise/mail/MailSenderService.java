package Mk.JD2_95_22.fitness.servise.mail;


import Mk.JD2_95_22.fitness.servise.api.mail.IMailSenderService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements IMailSenderService {
    private JavaMailSender mailSender;

    public MailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendActiveMail(String to, String code,String subject)  {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("vitaliysokolov1@gmail.com");
            message.setTo(to);
            message.setSubject("Confirm mail");
            message.setText("Click to address " +
                    ":http://localhost:8080/api/v1/users/verification?code=  " + code +
                    "&mail=" + to );
            mailSender.send(message);
        }
        catch (MailException e){e.printStackTrace();
        }
    }
}
