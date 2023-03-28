package Mk.JD2_95_22.fitness.core.exception.user;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){};

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
