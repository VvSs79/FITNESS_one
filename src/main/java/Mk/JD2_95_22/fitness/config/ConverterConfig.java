package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.converter.product.ProductConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.product.ProductConvertertEntityToDTO;
import Mk.JD2_95_22.fitness.converter.user.UserConverterDTOtoToEntity;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToDTO;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.user.UserConverterEntityToPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //user
        registry.addConverter(new UserConverterDTOtoToEntity());
        registry.addConverter(new UserConverterEntityToDTO());
        registry.addConverter(new UserConverterEntityToModel());
        registry.addConverter(new UserConverterEntityToPage());
        registry.addConverter(new UserConverterDTOtoToEntity());

        //product
        registry.addConverter(new UserConverterDTOtoToEntity());
        registry.addConverter(new UserConverterEntityToPage());
        registry.addConverter(new ProductConvertertEntityToDTO());
        registry.addConverter(new ProductConverterEntityToModel());

    }
}
