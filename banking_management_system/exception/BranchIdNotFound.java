package com.qsp.banking_management_system.exception;

public class BranchIdNotFound extends RuntimeException{
private String message="BranchId is not present";

public String getMessage() {
	return message;
}

}
