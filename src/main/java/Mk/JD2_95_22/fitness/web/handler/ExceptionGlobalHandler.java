package Mk.JD2_95_22.fitness.web.handler;

import Mk.JD2_95_22.fitness.core.exeption.MultipleError;
import Mk.JD2_95_22.fitness.core.exeption.SingleError;
import Mk.JD2_95_22.fitness.servise.my_exeption.product.*;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserAlreadyExistException;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserValidateExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.version.InvalidVersionExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;


@RestControllerAdvice
public class ExceptionGlobalHandler {
    //400 @Validated
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MultipleError> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<SingleError> error = e.getBindingResult().getFieldErrors().stream()
                .map(s -> new SingleError(s.getField(), s.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MultipleError());
    }
    //    400
    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<List<MultipleError>>  ArgumentUserNotValidException(
            UserValidateExeption e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(List.of(new MultipleError()));
    }

    @ExceptionHandler(value = {RecipeValidateExeption.class})
    public ResponseEntity<MultipleError> ArgumentRecipeNotValidException(
            RecipeValidateExeption e) {
        List<SingleError> collect = Arrays.stream(e.getSuppressed())
                .map(s -> new SingleError(s.getMessage(),s.getCause().getMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MultipleError());
    }
    //    404
    @ExceptionHandler(value = {UserNotFoundExeption.class,
            ProductNotFoundExeption.class,
            RecipeNotFoundExeption.class})
    public ResponseEntity<List<MultipleError>>  ArgumentUserNotFoundException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of(new MultipleError()));
    }
    //    409
    @ExceptionHandler(value = {ProductAlreadyExistException.class})
    public ResponseEntity<List<MultipleError>> ArgumentProductAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleError()));
    }
    @ExceptionHandler(value = {RecipeAlreadyExistException.class})
    public ResponseEntity<List<MultipleError>> ArgumentRecipeAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleError()));
    }
    @ExceptionHandler(value = {UserAlreadyExistException.class })
    public ResponseEntity<List<MultipleError>> ArgumentUserAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleError()));
    }    @ExceptionHandler(value = {InvalidVersionExeption.class})
    public ResponseEntity<List<MultipleError>> ArgumentInvalidVersionException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleError()));
    }
    //    500
    @ExceptionHandler
    public ResponseEntity<List<MultipleError>> handlerNPE(Throwable e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new MultipleError()));
    }

}
