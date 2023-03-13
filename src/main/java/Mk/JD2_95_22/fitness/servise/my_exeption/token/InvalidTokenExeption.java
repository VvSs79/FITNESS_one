package Mk.JD2_95_22.fitness.servise.my_exeption.token;

public class InvalidTokenExeption extends RuntimeException{
    public InvalidTokenExeption(String message) {
        super(message);
    }

    public InvalidTokenExeption() {    }

    public InvalidTokenExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
