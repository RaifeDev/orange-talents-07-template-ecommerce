package br.com.desafiomercadolivre.exceptions;

import br.com.desafiomercadolivre.modelos.respostas.HandlerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerFormularios {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<HandlerResponse>> errosDeFormulario(MethodArgumentNotValidException exception){
        List<HandlerResponse> listaDeErros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            HandlerResponse handlerResponse = new HandlerResponse(exception.getClass().getName(), HttpStatus.BAD_REQUEST.value(),
                    error.getField(), error.getDefaultMessage());
            listaDeErros.add(handlerResponse);
        });

        return ResponseEntity.badRequest().body(listaDeErros);

    }



}
