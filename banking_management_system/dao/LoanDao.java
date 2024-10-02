package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.LoanRepo;

@Repository
public class LoanDao {
	@Autowired
	LoanRepo loanRepo;
	
	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	public Loan fetchLoanById(int loanId) {	
	Optional<Loan>	loan= loanRepo.findById(loanId);
	if(loan.isPresent()) {
		return loan.get();
	}
	else {
		return null;
	}
	}
	public Loan upateLoanById(int oldId, Loan newLoan) {
		newLoan.setLoanId(oldId);
		return loanRepo.save(newLoan);
	}
	public Loan deleteLoanById(int loanId) {
		Loan loan=loanRepo.findById(loanId).get();
		loanRepo.delete(loan);
		return loan;
	}
	public List<Loan> fetchAllLoans() {
		return loanRepo.findAll();
	}
}
