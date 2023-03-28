package Mk.JD2_95_22.fitness.core.exception.product;

public class ProductAlreadyExistException extends RuntimeException{
    public ProductAlreadyExistException(){};

    public ProductAlreadyExistException(String message) {
        super(message);
    }

    public ProductAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
