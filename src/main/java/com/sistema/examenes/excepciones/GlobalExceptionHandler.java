package com.sistema.examenes.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNotFoundException.class)

    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UsuarioNotFoundException ex) {

        ErrorDetails error = ErrorDetails.builder().status("404").message(ex.getMessage()).build();

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UsuarioFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserFoundException(UsuarioFoundException ex) {

        ErrorDetails error = ErrorDetails.builder().status("404").message(ex.getMessage()).build();

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidRequestException.class)

    public ResponseEntity<ErrorDetails> handleInvalidRequestException(InvalidRequestException ex) {

        ErrorDetails error = ErrorDetails.builder().status("400").message(ex.getMessage()).build();

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ErrorDetails error = ErrorDetails.builder().status("404").message(ex.getMessage()).build();

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error-> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap ;
    }
}
