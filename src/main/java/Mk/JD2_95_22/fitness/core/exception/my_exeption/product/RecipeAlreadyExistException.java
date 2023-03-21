package Mk.JD2_95_22.fitness.core.exception.my_exeption.product;

public class RecipeAlreadyExistException extends RuntimeException{
    public RecipeAlreadyExistException(){};
    public RecipeAlreadyExistException(String message) {
        super(message);
    }

    public RecipeAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipeAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
