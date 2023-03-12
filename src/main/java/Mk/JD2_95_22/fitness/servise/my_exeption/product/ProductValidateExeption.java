package Mk.JD2_95_22.fitness.servise.my_exeption.product;

public class ProductValidateExeption extends IllegalArgumentException{
    public ProductValidateExeption(){};
    public ProductValidateExeption(String message) {
        super(message);
    }
}
