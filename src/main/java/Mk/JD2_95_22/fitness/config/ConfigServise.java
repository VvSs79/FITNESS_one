package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.converter.user.*;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.UserServise;
import Mk.JD2_95_22.fitness.servise.api.IUserServise;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigServise {

  @Bean
    public IUserServise userService(IUserRepository repository,
                                    UserConverterDtoToEntity userConverterDtoToEntity,
                                    UserConverterEntityToDTO userConverterEntityToDTO,
                                    UserConverterEntityToModel userConverterEntityToModel,
                                    UserConverterEntityToPage userConverterEntityToPage
                                    ){
        return new UserServise(repository,
                userConverterDtoToEntity,
                userConverterEntityToDTO,
                userConverterEntityToModel,
                userConverterEntityToPage);
    }
    \

}
