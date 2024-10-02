package com.qsp.banking_management_system.exception;

public class AccountIdNotFound extends RuntimeException {
private String message ="Account Id is not present in DB";

public String getMessage() {
	return message;
}

}
