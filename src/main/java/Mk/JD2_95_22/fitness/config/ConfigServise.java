package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.converter.user.ConverterToPageUser;
import Mk.JD2_95_22.fitness.converter.user.ConverterDtoToModel;
import Mk.JD2_95_22.fitness.converter.user.UserConverter;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.UserServise;
import Mk.JD2_95_22.fitness.servise.api.IUserServise;
import org.springframework.context.annotation.Bean;

public class ConfigServise {

    @Bean
    public IUserServise userService(IUserRepository repository, UserConverter converterUserToUserEntity,
                                    ConverterToPageUser converterUserEntityToPageUser,
                                    ConverterDtoToModel converterUserEntityToUserModel){
        return new UserServise(repository,
                converterUserEntityToPageUser,
                converterUserEntityToUserModel,
                converterUserToUserEntity);
    }
    @Bean
    public IAuthenticationService authenticationService(IAuthenticationDao dao, IUserService service){
        return new AuthenticationService(dao, service);
    }
    @Bean
    public IProductService productService(IProductDao dao,
                                          CustomProductDTOConverter converterProductDTO,
                                          CustomProductEntityConverter converterProductEntity ){
        return new ProductService(dao,converterProductDTO,converterProductEntity);
    }
    @Bean
    public IRecipeService recipeService(IRecipeDao dao, IProductService service ){
        return new RecipeService(dao, service);
    }

}
