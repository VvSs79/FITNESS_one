package Mk.JD2_95_22.fitness.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class ModelMapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModelMapperApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
