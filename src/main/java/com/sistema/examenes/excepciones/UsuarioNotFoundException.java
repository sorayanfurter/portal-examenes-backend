package com.sistema.examenes.excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {


    public UsuarioNotFoundException(String message) {
        super(message);
    }



}
