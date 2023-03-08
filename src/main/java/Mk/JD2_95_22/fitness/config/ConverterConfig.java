package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.converter.mail.MailConverterEntityTolDTO;
import Mk.JD2_95_22.fitness.converter.number_format.DoubleConverter;
import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import Mk.JD2_95_22.fitness.converter.product.ProductConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.product.ProductConvertertEntityToDTO;
import Mk.JD2_95_22.fitness.converter.user.UserConverterDtoToEntity;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToDTO;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
//user
        registry.addConverter(new UserConverterDtoToEntity());
        registry.addConverter(new UserConverterEntityToDTO());
        registry.addConverter(new UserConverterEntityToModel());
        registry.addConverter(new UserConverterEntityToPage());
        registry.addConverter(new UserConverterDtoToEntity());

//product
        registry.addConverter(new UserConverterDtoToEntity());
        registry.addConverter(new UserConverterEntityToPage());
        registry.addConverter(new ProductConvertertEntityToDTO());
        registry.addConverter(new ProductConverterEntityToModel());

//mail
        registry.addConverter(new UserConverterDtoToEntity());
        registry.addConverter(new MailConverterEntityTolDTO());

//number
        registry.addConverter((Converter<?, ?>) new DoubleConverter());
        registry.addConverter((Converter<?, ?>) new InstantConverter());

    }
}
