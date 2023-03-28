package Mk.JD2_95_22.fitness.core.exception.product;

public class ProductNotFoundExeption extends RuntimeException{
    public ProductNotFoundExeption(){};

    public ProductNotFoundExeption(String message) {
        super(message);
    }

    public ProductNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
