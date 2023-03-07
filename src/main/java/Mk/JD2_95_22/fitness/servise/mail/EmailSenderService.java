package Mk.JD2_95_22.fitness.servise.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.servise.api.IEmailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailSenderService implements IEmailSenderService {
    private final JavaMailSender javaMailSender;
    private final static Logger logger = LoggerFactory.getLogger(EmailSenderService.class);
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendActiveMail(@NotNull String mail, MailDTO mailDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mailDTO.getMailContent(), true);
            helper.setTo(mailDTO.getEmailTo());
            helper.setSubject("Confirm your email");
            helper.setFrom("vitaliysokolov1@gmail.com");
            javaMailSender.send(mimeMessage);
            logger.info("Sending link for activation ta mail: " + mailDTO.getEmailTo());
        } catch (MessagingException e) {
            logger.error("Failed to send email for: " + mailDTO.getEmailTo() + "\n" + e);
            throw new IllegalArgumentException("Failed to send email for: " + mailDTO.getEmailTo());

        }
    }

}
