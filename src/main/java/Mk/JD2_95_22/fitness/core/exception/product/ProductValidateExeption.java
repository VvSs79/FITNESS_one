package Mk.JD2_95_22.fitness.core.exception.product;

public class ProductValidateExeption extends IllegalArgumentException{
    public ProductValidateExeption(){};

    public ProductValidateExeption(String message) {
        super(message);
    }

    public ProductValidateExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductValidateExeption(Throwable cause) {
        super(cause);
    }
}
