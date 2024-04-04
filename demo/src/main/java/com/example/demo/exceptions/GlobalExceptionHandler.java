package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidationExceptions(MethodArgumentNotValidException m, WebRequest wr) {
        Map<String, String> erros = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeDoCampo = ((org.springframework.validation.FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            erros.put(nomeDoCampo, mensagemDeErro);
        });

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("Erro", "Verifique se o corpo da mensagem está correto.");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
