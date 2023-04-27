package com.example.cafe.exception;

public class DoesnotExistsException extends RuntimeException {
	public DoesnotExistsException (String msg) {
		super(msg);
	}
}
