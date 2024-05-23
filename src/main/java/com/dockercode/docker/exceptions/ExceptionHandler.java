package com.dockercode.docker.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    //ID: Indica que es un manejador de excepciones específicas, y para el caso serán tipo (NotFoundCustomException.class)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundCustomException.class)

    /*
        Método que recibirá un msg de (NotFoundCustomException.class) y lo sumará al Status y Date
        de la Clase (NotFoundCustomExceptionResponse)para responder en caso de no encontrar la entidad
        buscada.
    */
    @ResponseBody
    public NotFoundCustomExceptionResponse entityNotFound (NotFoundCustomException exception){

        return new NotFoundCustomExceptionResponse
                (HttpStatus.BAD_REQUEST, exception.getMessage(), new Date());
    }


    //Método para darle manejo a los errores por incumplimiento de Validaciones - Hereda de (ResponseEntityExceptionHandler)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error). getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
