package com.sistema.examenes.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsuarioFoundException extends RuntimeException{

    public UsuarioFoundException(String message) {
        super(message);
    }
}
