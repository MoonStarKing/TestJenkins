package com.example.demojenkins.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(String message,Integer code){
        super(message);
        this.code = code;
    }

}
