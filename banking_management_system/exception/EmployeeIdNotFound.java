package com.qsp.banking_management_system.exception;

public class EmployeeIdNotFound extends RuntimeException {
private String message="Employee Id is not present in DB";

public String getMessage() {
	return message;
}

}
