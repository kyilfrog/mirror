package com.grgr.exception;


public class WriteNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WriteNullException() {
		// TODO Auto-generated constructor stub
	}
	
	public WriteNullException(String message) {
        super(message);
    }
}
