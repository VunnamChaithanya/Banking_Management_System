package com.qsp.banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.service.LoanService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	
	@PostMapping("/saveLoan")
	public ResponseStructure<Loan> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}
	@GetMapping("/fetchLoanById")
	public ResponseStructure<Loan> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}
	@PutMapping("/updateLoanById")
	public ResponseStructure<Loan> updateLoanById(@RequestParam int oldId,@RequestBody Loan newLoan) {
		return loanService.updateLoanById(oldId, newLoan);
	}
	@DeleteMapping("/deleteLoanById")
	public ResponseStructure<Loan> deleteLoanById(@RequestParam int loanId) {
		return loanService.deleteLoanById(loanId);
	}
	@GetMapping("/fetchAllLoans")
	public ResponseStructureList<Loan> fetchAllLoans() {
		return loanService.fetchAllLoans();
	}
}
