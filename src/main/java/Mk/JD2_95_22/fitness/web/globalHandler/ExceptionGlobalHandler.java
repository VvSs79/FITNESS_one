package Mk.JD2_95_22.fitness.web.globalHandler;

import Mk.JD2_95_22.fitness.core.dto.erorr.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.erorr.MyError;
import Mk.JD2_95_22.fitness.core.dto.erorr.SingleErrorResponse;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.VersionException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<SingleErrorResponse> onConstraintValidationException(
            ConstraintViolationException e
    ) {
        final List<SingleErrorResponse> singleErrorResponseList = e.getConstraintViolations().stream().
                map(error -> new SingleErrorResponse("error", e.getMessage())).collect(Collectors.toList());
        return singleErrorResponseList;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MultipleErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        final List<MyError> myErrors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new MyError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new MultipleErrorResponse("structured_error", myErrors);
    }


    @ExceptionHandler({DoubleException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public MultipleErrorResponse checkDoubleException(
            RuntimeException e
    ) {
        final List<MyError> myErrors = Collections.singletonList(new MyError("error", e.getMessage()));
        return new MultipleErrorResponse("structured_error", myErrors);
    }

    @ExceptionHandler({VersionException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MultipleErrorResponse checkVersionException(
            RuntimeException e
    ) {
        final List<MyError> myErrors = Collections.singletonList(new MyError("error", e.getMessage()));
        return new MultipleErrorResponse("structured_error", myErrors);
    }
}