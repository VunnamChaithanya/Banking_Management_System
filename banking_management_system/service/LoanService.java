package com.qsp.banking_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.LoanDao;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.exception.LoanIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@Service
public class LoanService {
	@Autowired
	LoanDao loanDao;
	@Autowired
	ResponseStructure<Loan> responseStructure;
	@Autowired
	ResponseStructureList<Loan> responseStructureList;
	public ResponseStructure<Loan>  saveLoan(Loan loan) {
		responseStructure.setMessage("Successfully loan inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return responseStructure;
	}
	public ResponseStructure<Loan>  fetchLoanById(int loanId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		if(loan != null) {
		responseStructure.setMessage("Successfully loan fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(loanDao.fetchLoanById(loanId));
		return responseStructure;
		}else {
			throw new LoanIdNotFound();
		}
	}
	public ResponseStructure<Loan>  updateLoanById(int oldId,Loan newLoan) {
		Loan loan=loanDao.fetchLoanById(oldId);
		if(loan != null) {
		responseStructure.setMessage("Successfully loan updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.upateLoanById(oldId, newLoan));
		return responseStructure;
		}else{
			throw new LoanIdNotFound();
		}
	}
	public ResponseStructure<Loan>  deleteLoanById(int loanId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		if(loan != null) {
		responseStructure.setMessage("Successfully loan deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.deleteLoanById(loanId));
		return responseStructure;
		}
		else {
	       throw new LoanIdNotFound();
		}
	}
	public ResponseStructureList<Loan> fetchAllLoans(){
		responseStructureList.setMessage("Successfully fetched all loans from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(loanDao.fetchAllLoans());
	    return responseStructureList ;
	}
	

}
