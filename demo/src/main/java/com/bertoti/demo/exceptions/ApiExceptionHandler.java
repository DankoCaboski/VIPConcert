package com.bertoti.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleNumberFormatException(NumberFormatException e){
        StackTraceElement[] stackTrace = e.getStackTrace();
        String methodName = stackTrace[0].getMethodName();
        log.error("Number format exception in method {}: {}", methodName, e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
