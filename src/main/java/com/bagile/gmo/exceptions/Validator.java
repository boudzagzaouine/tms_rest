package com.bagile.gmo.exceptions;

import java.io.Serializable;

public class Validator implements Serializable {
    private String field;
    private String message;
    private String path;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return
                message ;

    }
}