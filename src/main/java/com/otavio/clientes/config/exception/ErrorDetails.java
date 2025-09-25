package com.otavio.clientes.config.exception;

public class ErrorDetails {
    private String code;
    private String message;

    public ErrorDetails (String code, String message){
        this.code = code;
        this.message =message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
