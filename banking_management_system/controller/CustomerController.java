package com.qsp.banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Account;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.service.CustomerService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}
	@PutMapping("/updateCustomerById")
	public ResponseStructure<Customer> updateCustomerById(@RequestParam int oldId,@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldId, newCustomer);
	}
	@DeleteMapping("/deleteCustomerById")
	public ResponseStructure<Customer> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	@GetMapping("/fetchAllCustomers")
	public ResponseStructureList<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}
	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(@RequestParam int accountId ,@RequestParam int customerId) {
		return customerService.addExistingAccountToExistingCustomer(accountId, customerId);
	}
	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int customerId ,@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer( customerId ,newAccount);
	}
	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(@RequestParam int cardId ,@RequestParam int customerId) {
		return customerService.addExistingCardToExistingCustomer(cardId , customerId) ; 
	}
	@PutMapping("/addNewCardExistingCustomer")
	public ResponseStructure<Customer> addNewCardExistingCustomer(@RequestParam int customerId ,@RequestBody Card newCard) {
		return customerService.addNewCardExistingCustomer(customerId, newCard);
	}
	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(int loanId , int customerId) {
		return customerService.addExistingLoanToExistingCustomer(loanId, customerId);
	}
	@PutMapping("/addNewLoanExistingCustomer")
	public ResponseStructure<Customer> addNewLoanExistingCustomer(@RequestParam int customerId ,@RequestBody Loan newLoan) {
		return customerService.addNewLoanExistingCustomer(customerId, newLoan);
	}

}
