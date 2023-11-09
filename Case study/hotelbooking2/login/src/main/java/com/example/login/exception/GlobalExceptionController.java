package com.example.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<ErrorDetail> handleInvalidRoleException(InvalidRoleException ex, WebRequest request)
    {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleUserNotFoundException(UserNotFoundException ex,WebRequest request)
    {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);

    }
}
