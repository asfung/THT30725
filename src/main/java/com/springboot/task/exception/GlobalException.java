package com.springboot.task.exception;

import javax.validation.ConstraintViolationException;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.task.utils.response.StandardResponseWrapper;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalException {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardResponseWrapper> handleNotFound(NotFoundException ex) {
    log.error("Not Found: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new StandardResponseWrapper(false, ex.getMessage()));
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<StandardResponseWrapper> handleBadRequest(BadRequestException ex) {
    log.error("Bad Request: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new StandardResponseWrapper(false, ex.getMessage()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardResponseWrapper> handleValidation(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldError() != null
        ? ex.getBindingResult().getFieldError().getDefaultMessage()
        : "Validation error";
    log.error("Validation Failed: {}", message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new StandardResponseWrapper(false, message));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<StandardResponseWrapper> handleConstraintViolation(ConstraintViolationException ex) {
    log.error("Constraint Violation: {}", ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new StandardResponseWrapper(false, "Constraint violation: " + ex.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<StandardResponseWrapper> handleGeneric(Exception ex) {
    log.error("Unhandled Exception", ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new StandardResponseWrapper(false, "Internal Server Error"));
  }

}
