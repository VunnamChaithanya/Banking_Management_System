package com.qsp.banking_management_system.exception;

public class LoanIdNotFound extends RuntimeException {
	private String message="Loan Id is not present in DB";

	public String getMessage() {
		return message;
	}

}
