package com.example.cafe.exception;

public class AlreadyExistsException extends RuntimeException {
		public AlreadyExistsException(String msg) {
			super(msg);
		}
}
