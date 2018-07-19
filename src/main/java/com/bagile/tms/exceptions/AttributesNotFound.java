package com.bagile.tms.exceptions;

public class AttributesNotFound extends Exception {

    private static final long serialVersionUID = -7854995033789787698L;

    public AttributesNotFound() {
    }

    public AttributesNotFound(String message) {
        super(message + " : introuvable");
    }

    public AttributesNotFound(Throwable cause) {
        super(cause);
    }

    public AttributesNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributesNotFound(String message, Throwable cause,
                              boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
