package Mk.JD2_95_22.fitness.web.globalHandler;

import Mk.JD2_95_22.fitness.core.dto.erorr.ListErrorDTO;
import Mk.JD2_95_22.fitness.core.dto.erorr.ErrorDTO;
import Mk.JD2_95_22.fitness.core.dto.erorr.StructuredErrorDTO;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.VersionException;
import Mk.JD2_95_22.fitness.core.exception.product.*;
import Mk.JD2_95_22.fitness.core.exception.user.UserAlreadyExistException;
import Mk.JD2_95_22.fitness.core.exception.user.UserValidateExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler
    public ResponseEntity<List<ErrorDTO>> handler(Throwable e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ErrorDTO("error",e.getMessage())));
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class,
            MethodArgumentConversionNotSupportedException.class})
    public ResponseEntity<List<ErrorDTO>> onArgumentTypeMismatchException(
            HttpMessageNotReadableException e ) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }

    @ExceptionHandler()
    public ResponseEntity<List<ErrorDTO>> onHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ListErrorDTO> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<StructuredErrorDTO> error = e.getBindingResult().getFieldErrors().stream()
                .map(s -> new StructuredErrorDTO(s.getField(), s.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ListErrorDTO(error));
    }
    @ExceptionHandler(value = {RecipeValidateExeption.class})
    public ResponseEntity<ListErrorDTO> ArgumentRecipeValidateExeption(
            RecipeValidateExeption e) {
        List<StructuredErrorDTO> collect = Arrays.stream(e.getSuppressed())
                .map(s -> new StructuredErrorDTO(s.getMessage(),s.getCause().getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ListErrorDTO(collect));
    }

    @ExceptionHandler(value = {ProductValidateExeption.class})
    public ResponseEntity<ListErrorDTO> ArgumentProductValidateExeption(
            RecipeValidateExeption e) {
        List<StructuredErrorDTO> collect = Arrays.stream(e.getSuppressed())
                .map(s -> new StructuredErrorDTO(s.getMessage(),s.getCause().getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ListErrorDTO(collect));
    }

    @ExceptionHandler(value = {UserValidateExeption.class})
    public ResponseEntity<ListErrorDTO> ArgumentUserValidateExeption(
            RecipeValidateExeption e) {
        List<StructuredErrorDTO> collect = Arrays.stream(e.getSuppressed())
                .map(s -> new StructuredErrorDTO(s.getMessage(),s.getCause().getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ListErrorDTO(collect));
    }

    @ExceptionHandler(value = {ProductNotFoundExeption.class})
    public ResponseEntity<List<ErrorDTO>>  ArgumentProductNotFoundExeption(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of(new ErrorDTO("error",e.getMessage())));
    }

    @ExceptionHandler(value = {RecipeNotFoundExeption.class})
    public ResponseEntity<List<ErrorDTO>>  ArgumentRecipeNotFoundExeption(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of(new ErrorDTO("error",e.getMessage())));
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<List<ErrorDTO>>  ArgumentUsernameNotFoundException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of(new ErrorDTO("error",e.getMessage())));
    }

    @ExceptionHandler(value = {ProductAlreadyExistException.class})
    public ResponseEntity<List<ErrorDTO>> ArgumentProductAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new ErrorDTO("error",e.getMessage())));
    }


    @ExceptionHandler(value = {RecipeAlreadyExistException.class})
    public ResponseEntity<List<ErrorDTO>> ArgumentRecipeAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }

    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<List<ErrorDTO>> ArgumentUserAlreadyExistException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }

    @ExceptionHandler(value = {VersionException.class})
    public ResponseEntity<List<ErrorDTO>> ArgumentVersionException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }
    @ExceptionHandler({DoubleException.class})
    public ResponseEntity<List<ErrorDTO>> ArgumentDoubleException(
            RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(List.of(new ErrorDTO("error", e.getMessage())));
    }

}