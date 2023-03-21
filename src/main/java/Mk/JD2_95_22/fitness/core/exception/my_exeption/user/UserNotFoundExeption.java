package Mk.JD2_95_22.fitness.core.exception.my_exeption.user;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(){};

    public UserNotFoundExeption(String message) {
        super(message);
    }

    public UserNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
