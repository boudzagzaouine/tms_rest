package com.bagile.tms.exceptions;

public class IdNotFound extends Exception {

	public IdNotFound() {
	}

	public IdNotFound(Long id) {
		super("id : '" + id + "' est introuvable");
	}

	public IdNotFound(Throwable cause) {
		super(cause);
	}

	public IdNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public IdNotFound(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
