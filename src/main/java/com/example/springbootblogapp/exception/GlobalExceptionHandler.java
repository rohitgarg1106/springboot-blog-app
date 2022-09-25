package com.example.springbootblogapp.exception;

import com.example.springbootblogapp.utils.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            HttpServletRequest req, Exception e
    ){
        ErrorDetails ed = new ErrorDetails(new Date(),e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
    }

    @ExceptionHandler(BadMappingException.class)
    public ResponseEntity<ErrorDetails> handleBadMappingException(
            HttpServletRequest req, Exception e
    ){
        ErrorDetails ed = new ErrorDetails(new Date(),e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
    }

//    Global Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(
            HttpServletRequest req, Exception e
    ){
        ErrorDetails ed = new ErrorDetails(new Date(),e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ed);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(
//            HttpServletRequest req, Exception e,
//
//    )
}
