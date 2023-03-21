package Mk.JD2_95_22.fitness.core.exception.my_exeption.product;

import org.springframework.core.convert.ConverterNotFoundException;

public class RecipeValidateExeption extends IllegalArgumentException{
    public RecipeValidateExeption(){};
    public RecipeValidateExeption(String message) {
        super(message);
    }

    public RecipeValidateExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipeValidateExeption(Throwable cause) {
        super(cause);
    }
}
