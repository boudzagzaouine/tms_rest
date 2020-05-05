package com.bagile.gmo.exceptions;

/**
 * Created by adadi on 12/30/2015.
 */
public class ErrorType extends Exception {
    public ErrorType() {
        super();
    }

    public ErrorType(String field, String type, String value) {
        super("error in next operation '" + field + "'=" + value + "' because the field is the type :'" + type + "'");
    }

    public ErrorType(String message) {
        super(message);
    }

    public ErrorType(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorType(Throwable cause) {
        super(cause);
    }

    protected ErrorType(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
