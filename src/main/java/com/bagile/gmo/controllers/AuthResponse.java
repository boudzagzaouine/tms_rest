package com.bagile.gmo.controllers;

public class AuthResponse {
    private boolean success;
    private String token;
    private String type;
    private String message;

    public AuthResponse() {}

    public AuthResponse(boolean success, String token, String type, String message) {
        this.success = success;
        this.token = token;
        this.type = type;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

