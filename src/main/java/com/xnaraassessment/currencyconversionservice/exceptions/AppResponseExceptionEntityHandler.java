package com.xnaraassessment.currencyconversionservice.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
@RestController
public class AppResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "Something went wrong, please try again later. You can ask admin to check the application logs."
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Map<String, String>> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().stream().forEach((error) -> {
            HashMap<String, String> errorData = new HashMap<>();
            errorData.put(error.getField(), error.getDefaultMessage());
            errors.add(errorData);
        });
        ExceptionResponse exceptionResponse = new ExceptionResponse(

                "There are some validation constraints are failing in your request. Please fix listed validation errors!",
                errors
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TransactionSystemException.class, ConstraintViolationException.class})
    public final ResponseEntity<Object> handleConstraintException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage()
        );
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
