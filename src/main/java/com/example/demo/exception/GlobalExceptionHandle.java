package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(NotSupportOperationException.class)
    public ResponseEntity notSupportOperationHandle(Exception ex) {
        CommonError returnError =
                new CommonError(new Date(), "Not Support operation", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnError);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity NullPointerExceptionHandle(Exception ex) {
        CommonError returnError =
                new CommonError(new Date(), "something wrong", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validationFailed(Exception ex) {
        CommonError returnError =
                new CommonError(new Date(), "validate failed", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnError);
    }

}
