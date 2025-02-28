package com.exmaple.dio.exception.handler;

import com.exmaple.dio.exception.UserNotFoundByIdException;
import com.exmaple.dio.utility.ErrorResponse;
import com.exmaple.dio.utility.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdException.class)

    public ResponseEntity<ErrorResponse> getMessage(UserNotFoundByIdException ex){
        return ResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage());

    }


}
