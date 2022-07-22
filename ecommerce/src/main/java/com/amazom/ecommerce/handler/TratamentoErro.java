package com.amazom.ecommerce.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TratamentoErro extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

                List<String> mensagensErro = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(m -> String.format("O campo %s está com o erro %s",  m.getField(), m.getDefaultMessage()) )
                .collect(Collectors.toList());


        return new ResponseEntity<>(mensagensErro, HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

                String mensagem = "Erro na conversão de algum tipo. Verifique mais detalhes na mensagem: \n" + ex.getMessage();

        return new ResponseEntity<>(mensagem, HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

                String mensagem = "Só é aceito formato JSON, verifique media type enviado\n" + ex.getMessage();

                return new ResponseEntity<>(mensagem, HttpStatus.NOT_ACCEPTABLE);
    }

    
    
    
    
}
