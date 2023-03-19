package Mk.JD2_95_22.fitness.servise.my_exeption.token;

public class TokenExeption extends RuntimeException{
    public TokenExeption(String message) {
        super(message);
    }

    public TokenExeption() {    }

    public TokenExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
