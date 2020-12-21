package com.crm.commun.exceptions;

import com.crm.commun.configs.ConfigProperties;
import com.fasterxml.jackson.core.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author hsassa
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionResponse> exception(NumberFormatException ex) {
        log.error("NumberFormatException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("40");
        response.setErrorMessage(Arrays.asList("Number Format Error"));
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ExceptionResponse> exception(JDBCConnectionException ex) {
        log.error("JDBCConnectionException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("41");
        response.setErrorMessage(Arrays.asList("DB Internal Server Error"));
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JDBCException.class)
    public ResponseEntity<ExceptionResponse> exception(JDBCException ex) {
        log.error("JDBCException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("42");
        response.setErrorMessage(Arrays.asList("DB Internal Server Error"));
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ExceptionResponse> exception(JsonParseException ex) {
        log.error("HttpMessageNotReadableException,JsonParseException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("125");
        response.setErrorMessage(Arrays.asList("Format invalide"));
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WebException.class)
    public ResponseEntity<ExceptionResponse> exception(WebException ex) {
        log.error("WebException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("43");
        response.setErrorMessage(ex.errors);
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionResponse> exception(ServiceException ex) {
        log.error("ServiceException",ex);
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("44");
        response.setErrorMessage(ex.errors);
        response.setTimestamp(LocalDateTime.now());
        response.setApiVersion(ConfigProperties.appVersion);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

}
