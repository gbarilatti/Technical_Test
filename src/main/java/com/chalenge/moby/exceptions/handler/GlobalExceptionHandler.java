package com.chalenge.moby.exceptions.handler;

import com.chalenge.moby.exceptions.CandidateAlreadyExistsException;
import com.chalenge.moby.exceptions.CandidateNotExistsException;
import com.chalenge.moby.exceptions.TechnologyAlreadyExistsException;
import com.chalenge.moby.exceptions.TechnologyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CandidateAlreadyExistsException.class)
    public ResponseEntity<?> candidateAlreadyExistsHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(CandidateNotExistsException.class)
    public ResponseEntity<?> candidateNotFoundHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TechnologyAlreadyExistsException.class)
    public ResponseEntity<?> technologyAlreadyExistsHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity<?> technologyNotFoundHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
