package com.OnlineMobileStore.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MobileNotFoundException extends Exception {

    public MobileNotFoundException(String message){
        super(message);
    }
}
