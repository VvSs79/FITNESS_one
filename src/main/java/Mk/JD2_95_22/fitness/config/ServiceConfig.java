package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeCreatedForCU;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.MailStatus;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.orm.repository.IPersonalUserRepository;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.orm.repository.IRecipeRepository;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.security.util.JwtUtils;
import Mk.JD2_95_22.fitness.servise.api.mail.IMailSenderService;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import Mk.JD2_95_22.fitness.servise.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import Mk.JD2_95_22.fitness.servise.mail.MailSenderService;
import Mk.JD2_95_22.fitness.servise.product.ProductService;
import Mk.JD2_95_22.fitness.servise.product.RecipeService;
import Mk.JD2_95_22.fitness.servise.user.AuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.user.UserService;
import Mk.JD2_95_22.fitness.servise.validation.UserRegistrationValidator;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Properties;


@Configuration
public class ServiceConfig  {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(IUserRepository repository,
                                    IValidator<UserCreated> validator,
                                    ConversionService conversionService,
                                    PasswordEncoder encoder) {
        return new UserService(repository,validator, conversionService, encoder);
    }

    @Bean
    public IAuthenticationUserService authenticationService(IPersonalUserRepository repository,
                                                            IUserService service,
                                                            IMailSenderService emailService,
                                                            ConversionService conversionService,
                                                            BCryptPasswordEncoder encoder,
                                                            UserRegistrationValidator validator,
                                                            JwtUtils generateAccessToken) {


        return new AuthenticationUserService(repository,service,emailService,conversionService,encoder,validator, generateAccessToken);
    }

    @Bean
    public IProductService productService(IProductRepositpry repository, ConversionService conversionService, IValidator<ProductCreated> validator

        ) {
        return new ProductService(repository, conversionService,validator);
    }

    @Bean
    public IRecipeService recipeService(IRecipeRepository recepteRepository, IProductService productService,
                                        ConversionService conversionService,IValidator<RecipeCreatedForCU> validator) {
        return new RecipeService(recepteRepository, productService,conversionService, validator);
    }

    @Bean
    public IMailSenderService emailService(JavaMailSender emailSender, SimpleMailMessage template,
                                           MailStatus status, SpringTemplateEngine thymeleafTemplateEngine) {
        return new MailSenderService(emailSender, template,status,thymeleafTemplateEngine);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mail.ru");
        mailSender.setPort(587);
        mailSender.setUsername("test_project2023@mail.ru");
        mailSender.setPassword("C9W)m3Yyp$H=%JY:");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
