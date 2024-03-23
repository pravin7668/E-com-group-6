package com.exception;
import com.exception.*;
public class VendorNotFoundException extends Exception {

private static final long serialVersionUID = 1L;
	
	private String message;

	public VendorNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
