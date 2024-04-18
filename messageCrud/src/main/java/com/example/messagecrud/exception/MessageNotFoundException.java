package com.example.messagecrud.exception;

public class MessageNotFoundException extends RuntimeException {

	private String message;
	public MessageNotFoundException(String errorMessage) {
		this.message=errorMessage;
	// TODO Auto-generated constructor stub
}
	public MessageNotFoundException() {
		// TODO Auto-generated constructor stub
	}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
