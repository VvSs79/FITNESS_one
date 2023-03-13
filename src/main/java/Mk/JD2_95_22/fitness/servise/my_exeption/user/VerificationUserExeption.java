package Mk.JD2_95_22.fitness.servise.my_exeption.user;

public class VerificationUserExeption extends RuntimeException{
    public VerificationUserExeption() {
    }

    public VerificationUserExeption(String message) {
        super(message);
    }

    public VerificationUserExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationUserExeption(Throwable cause) {
        super(cause);
    }
}
