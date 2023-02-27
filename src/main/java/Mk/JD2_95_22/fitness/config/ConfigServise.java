package Mk.JD2_95_22.fitness.config;

public class ConfigServise {

    @Bean
    public IUserService userService(IUserDao dao, CustomUserEntityConverter converterUserEntity,
                                    CustomUserDTOConverter converterUserDTO){
        return new UserService(dao, converterUserEntity, converterUserDTO);
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
