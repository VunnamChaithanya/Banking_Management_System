package com.qsp.banking_management_system.exception;

public class cardIdNotFound extends RuntimeException {
private String message="Card Id is not found";

public String getMessage() {
	return message;
}

}
