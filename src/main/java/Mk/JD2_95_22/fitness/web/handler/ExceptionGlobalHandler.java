package Mk.JD2_95_22.fitness.web.handler;

import Mk.JD2_95_22.fitness.core.exeption.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.exeption.SingleErrorResponse;
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
    public ResponseEntity<MultipleErrorResponse> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<SingleErrorResponse> error = e.getBindingResult().getFieldErrors().stream()
                .map(s -> new SingleErrorResponse(s.getField(), s.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MultipleErrorResponse());
    }
    //    400
    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<List<MultipleErrorResponse>>  ArgumentUserNotValidException(
            UserValidateExeption e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(List.of(new MultipleErrorResponse()));
    }

    @ExceptionHandler(value = {RecipeValidateExeption.class})
    public ResponseEntity<MultipleErrorResponse> ArgumentRecipeNotValidException(
            RecipeValidateExeption e) {
        List<SingleErrorResponse> collect = Arrays.stream(e.getSuppressed())
                .map(s -> new SingleErrorResponse(s.getMessage(),s.getCause().getMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MultipleErrorResponse());
    }
    //    404
    @ExceptionHandler(value = {UserNotFoundExeption.class,
            ProductNotFoundExeption.class,
            RecipeNotFoundExeption.class})
    public ResponseEntity<List<MultipleErrorResponse>>  ArgumentUserNotFoundException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of(new MultipleErrorResponse()));
    }
    //    409
    @ExceptionHandler(value = {ProductAlreadyExistException.class})
    public ResponseEntity<List<MultipleErrorResponse>> ArgumentProductAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleErrorResponse()));
    }
    @ExceptionHandler(value = {RecipeAlreadyExistException.class})
    public ResponseEntity<List<MultipleErrorResponse>> ArgumentRecipeAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleErrorResponse()));
    }
    @ExceptionHandler(value = {UserAlreadyExistException.class })
    public ResponseEntity<List<MultipleErrorResponse>> ArgumentUserAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleErrorResponse()));
    }    @ExceptionHandler(value = {InvalidVersionExeption.class})
    public ResponseEntity<List<MultipleErrorResponse>> ArgumentInvalidVersionException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new MultipleErrorResponse()));
    }
    //    500
    @ExceptionHandler
    public ResponseEntity<List<MultipleErrorResponse>> handlerNPE(Throwable e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new MultipleErrorResponse()));
    }

}
