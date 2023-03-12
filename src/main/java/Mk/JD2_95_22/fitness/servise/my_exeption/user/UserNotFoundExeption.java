package Mk.JD2_95_22.fitness.servise.my_exeption.user;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(){};

    public UserNotFoundExeption(String message) {
        super(message);
    }
}
