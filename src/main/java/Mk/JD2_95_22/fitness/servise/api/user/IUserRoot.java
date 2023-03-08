package Mk.JD2_95_22.fitness.servise.api.user;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;

public interface IUserRoot {
    PageDTO<RecipeDTO> getAllRecepte();
    void uboutInformation(PageDTO<UserDTO> page, String mail, String password);
    void getRecepte(PageDTO<RecipeDTO> page, String title);
    PageDTO<ProductDTO> getAllProduct();
    void getProduct(PageDTO<ProductDTO> page, String nameProduct);
}
