package Mk.JD2_95_22.fitness.servise.my_exeption.product;

import org.springframework.core.convert.ConverterNotFoundException;

public class RecipeValidateExeption extends IllegalArgumentException{
    public RecipeValidateExeption(){};
    public RecipeValidateExeption(String message) {
        super(message);
    }

}
