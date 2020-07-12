package com.farheen.devices.api.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalHandler{

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException() {
        return new ResponseEntity<>("A Number format Exception has occured, pls enter the correct url", HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = ResourceNotFoundException.class)
//    public ResponseEntity<Object> handleResourceNotFoundException() {
//        System.out.println("APPLE");
//        return new ResponseEntity<>("Enter Url is not valid", HttpStatus.BAD_REQUEST);
//    }

}
