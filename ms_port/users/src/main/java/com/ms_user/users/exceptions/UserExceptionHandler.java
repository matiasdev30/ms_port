package com.ms_user.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(ErroSaveUserException.class)
    public ResponseEntity<ResponseModelError> entityNotFound(ErroSaveUserException e, HttpServletRequest request){
        ResponseModelError err = new ResponseModelError();
        err.setMsg("Erro a salvar o usuario, nome e email vazio");
        err.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModelError> argumentValidationError(MethodArgumentNotValidException e, HttpServletRequest request){
        ResponseModelError err = new ResponseModelError();
        err.setMsg(e.getMessage());
        err.setHttpStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
