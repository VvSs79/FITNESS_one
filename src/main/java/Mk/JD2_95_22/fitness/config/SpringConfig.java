package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.core.exception.validation.ProductValidator;
import Mk.JD2_95_22.fitness.core.exception.validation.RecipeValidator;
import Mk.JD2_95_22.fitness.core.exception.validation.UserCreatedValidator;
import Mk.JD2_95_22.fitness.core.exception.validation.UserRegistrationValidator;
import Mk.JD2_95_22.fitness.orm.repository.product.IProductRepository;
import Mk.JD2_95_22.fitness.orm.repository.product.IRecipeRepository;
import Mk.JD2_95_22.fitness.service.*;
import Mk.JD2_95_22.fitness.service.api.mail.IEmailService;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.service.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.service.api.user.IAuthenticationService;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD95_22.fitness.service.*;
import Mk.JD2_95_22.fitness.orm.repository.user.IAuthenticationUserRepository;
import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Properties;


@Configuration
public class SpringConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(IUserRepository dao,
                                    ConversionService conversionService,
                                    PasswordEncoder encoder,
                                    UserCreatedValidator validator) {
        return new UserService(dao,
                conversionService,
                encoder,
                validator);
    }

    @Bean
    public IAuthenticationService authenticationService(IAuthenticationUserRepository dao,
                                                        ConversionService conversionService,
                                                        IEmailService iEmailService,
                                                        IUserService iUserService,
                                                        UserRegistrationValidator validator) {
        return new AuthenticationService(dao,
                conversionService,
                iEmailService,
                iUserService,
                validator);
    }

    @Bean
    public IProductService productService(IProductRepository dao,
                                          ConversionService conversionService,
                                          ProductValidator validator) {
        return new ProductService(dao,
                conversionService,
                validator);
    }

    @Bean
    public IRecipeService recipeService(IRecipeRepository dao,
                                        IProductService productService,
                                        ConversionService conversionService,
                                        RecipeValidator validator) {
        return new RecipeService(dao,
                productService,
                conversionService,
                validator);
    }

    @Bean
    public IEmailService emailService(JavaMailSender emailSender) {
        return new EmailService(emailSender);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mail.ru");
        mailSender.setPort(465);
        mailSender.setUsername("ivanivanov2023_18@mail.ru");
        mailSender.setPassword("CzgX7LYBBE0GfaQPrZL6");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
