package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.ErroDTO;
import com.deveficiente.seeddesafiocdc.exception.ValidacaoExecption;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerContoller {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDTO> handleConstraintViolation(MethodArgumentNotValidException ex) {
        List<ErroDTO> mensagens = new ArrayList<>();
        for (FieldError error : ex.getFieldErrors()) {
            mensagens.add(new ErroDTO(error.getField(), error.getDefaultMessage()));
        }
        return mensagens;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidacaoExecption.class)
    public ErroDTO handleConstraintViolation(ValidacaoExecption ex) {
        return new ErroDTO(ex.getCampo(), ex.getError());
    }
}
