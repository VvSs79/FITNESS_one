package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.service.validate.RecipeValidator;
import Mk.JD2_95_22.fitness.orm.repository.product.IProductRepository;
import Mk.JD2_95_22.fitness.orm.repository.product.IRecipeRepository;
import Mk.JD2_95_22.fitness.service.*;
import Mk.JD2_95_22.fitness.service.api.mail.IMailService;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.service.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.service.api.user.IRegistrationService;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.orm.repository.user.IRegistrationUserRepository;
import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(IUserRepository dao,
                                    ConversionService conversionService,
                                    PasswordEncoder encoder) {
        return new UserService(dao,
                conversionService,
                encoder);
    }
    @Bean
    public IRegistrationService registrationService(IRegistrationUserRepository dao,
                                                      ConversionService conversionService,
                                                      IMailService iMailService,
                                                      IUserService iUserService,
                                                      PasswordEncoder encoder) {
        return new RegistrationService(dao,
                conversionService,
                iMailService,
                iUserService,
                encoder);
    }

    @Bean
    public IProductService productService(IProductRepository dao,
                                          ConversionService conversionService
                                          ) {
        return new ProductService(dao,
                conversionService);
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
}
