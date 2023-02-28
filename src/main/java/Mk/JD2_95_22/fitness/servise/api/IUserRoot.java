package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.Page;
import Mk.JD2_95_22.fitness.core.dto.products.Product;
import Mk.JD2_95_22.fitness.core.dto.products.Recipe;
import Mk.JD2_95_22.fitness.core.dto.user.User;

public interface IUserRoot {
    Page<Recipe> getAllRecepte();
    void uboutInformation(Page<User> page, String mail, String password);
    void getRecepte(Page<Recipe> page, String title);
    Page <Product> getAllProduct();
    void getProduct(Page<Product> page, String nameProduct);
}
