package com.qsp.banking_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.banking_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired 
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(BankIdNotFound.class)
	public ResponseStructure<String> bankIdNotFound(BankIdNotFound bankIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(bankIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(branchIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(cardIdNotFound.class)
	public ResponseStructure<String> cardIdNotFound(cardIdNotFound cardIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(cardIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseStructure<String> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(customerIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseStructure<String> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(employeeIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(LoanIdNotFound.class)
	public ResponseStructure<String> loanIdNotFound(LoanIdNotFound loanIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(loanIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(managerIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(AccountIdNotFound.class)
	public ResponseStructure<String> accountIdNotFound(AccountIdNotFound accountIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(accountIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure ;
	}
	@ExceptionHandler(AtmIdNotFound.class)
	public ResponseStructure<String> atmIdNotFound(AtmIdNotFound atmIdNotFound) {
		responseStructure.setMessage("Id is not present in DB ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(atmIdNotFound.getMessage());
		return responseStructure ;
	}

}
