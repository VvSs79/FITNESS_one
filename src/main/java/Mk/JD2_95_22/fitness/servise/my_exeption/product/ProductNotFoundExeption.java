package Mk.JD2_95_22.fitness.servise.my_exeption.product;

public class ProductNotFoundExeption extends RuntimeException{
    public ProductNotFoundExeption(){};
    public ProductNotFoundExeption(String message) {
        super(message);
    }
}
