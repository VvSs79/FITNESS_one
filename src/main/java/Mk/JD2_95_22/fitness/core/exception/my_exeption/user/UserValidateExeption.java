package Mk.JD2_95_22.fitness.core.exception.my_exeption.user;

public class UserValidateExeption extends IllegalArgumentException{
    public UserValidateExeption(){};

    public UserValidateExeption(String message) {
        super(message);
    }

    public UserValidateExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserValidateExeption(Throwable cause) {
        super(cause);
    }
}
