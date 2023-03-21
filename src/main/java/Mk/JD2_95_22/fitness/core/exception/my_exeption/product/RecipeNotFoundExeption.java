package Mk.JD2_95_22.fitness.core.exception.my_exeption.product;

public class RecipeNotFoundExeption  extends RuntimeException{
    public RecipeNotFoundExeption(){};
    public RecipeNotFoundExeption(String message) {
        super(message);
    }

    public RecipeNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipeNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
