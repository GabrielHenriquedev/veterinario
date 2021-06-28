package com.ifpe.veterinario.exceptions;

public class LoginServiceException extends Exception {
    public LoginServiceException(String message) {
        super(message);
    }
    private static final long serialVersionUID = 1L;
}
