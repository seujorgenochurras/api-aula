package com.apiaula.tutorial.apiaula.ApiExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

@Autowired
   private MessageSource messageSource;


   @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      GenericErrorResponse genericErrorResponse = new GenericErrorResponse(status.value(), "Invallid arguments", LocalDateTime.now());

      ex.getAllErrors().stream().filter(objectError -> objectError instanceof FieldError)
         .map(objectError -> (FieldError) objectError)
           .forEach(fieldError -> genericErrorResponse.addError(new
            GenericErrorResponse.ErrorColumns(fieldError.getField(),
                   messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))));

      return handleExceptionInternal(ex, genericErrorResponse,headers, status, request);
   }
}