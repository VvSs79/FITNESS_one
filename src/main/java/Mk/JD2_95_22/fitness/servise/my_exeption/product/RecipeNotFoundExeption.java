package Mk.JD2_95_22.fitness.servise.my_exeption.product;

public class RecipeNotFoundExeption  extends RuntimeException{
    public RecipeNotFoundExeption(){};
    public RecipeNotFoundExeption(String message) {
        super(message);
    }
}
