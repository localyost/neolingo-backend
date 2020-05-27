package com.neolingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created By p.yost on 20.05.2020
 */
@RestControllerAdvice
public class ErrorHandleController {

    @ExceptionHandler({NonExistentPlayerException.class, NonExistentGameException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomException(RuntimeException ce) {
        return ce.getClass().getSimpleName();
    }
}
