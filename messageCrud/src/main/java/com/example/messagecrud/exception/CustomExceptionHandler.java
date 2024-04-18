package com.example.messagecrud.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.messagecrud.exception.UserNotfoundException;

@ControllerAdvice
public class CustomExceptionHandler {
   @ExceptionHandler(value = UserNotfoundException.class)
   public ResponseEntity<Object> userNotFoundException(UserNotfoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler(value = MessageNotFoundException.class)
   public ResponseEntity<Object> messageNotFoundException(MessageNotFoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
}