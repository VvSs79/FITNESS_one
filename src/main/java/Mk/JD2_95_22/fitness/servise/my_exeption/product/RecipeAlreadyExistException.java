package Mk.JD2_95_22.fitness.servise.my_exeption.product;

public class RecipeAlreadyExistException extends RuntimeException{
    public RecipeAlreadyExistException(){};
    public RecipeAlreadyExistException(String message) {
        super(message);
    }
}
