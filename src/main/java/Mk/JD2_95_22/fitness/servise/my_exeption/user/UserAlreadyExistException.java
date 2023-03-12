package Mk.JD2_95_22.fitness.servise.my_exeption;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){};
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
