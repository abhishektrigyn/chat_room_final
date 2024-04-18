package com.example.messagecrud.exception;

public class UserNotfoundException extends RuntimeException{
	private String message;
	public UserNotfoundException() {
		// TODO Auto-generated constructor stub
	}
public UserNotfoundException(String message) {
	// TODO Auto-generated constructor stub
	this.message=message;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}


