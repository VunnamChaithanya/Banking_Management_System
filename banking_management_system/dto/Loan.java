package com.qsp.banking_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
private int loanId;
private long loanNumber;
private double loanTenure;
private double loanInterestRate;
private String loanType;
private double loanMaximumAmmount;


public int getLoanId() {
	return loanId;
}
public void setLoanId(int loanId) {
	this.loanId = loanId;
}
public long getLoanNumber() {
	return loanNumber;
}
public void setLoanNumber(long loanNumber) {
	this.loanNumber = loanNumber;
}
public double getLoanTenure() {
	return loanTenure;
}
public void setLoanTenure(double loanTenure) {
	this.loanTenure = loanTenure;
}
public double getLoanInterestRate() {
	return loanInterestRate;
}
public void setLoanInterestRate(double loanInterestRate) {
	this.loanInterestRate = loanInterestRate;
}
public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}
public double getLoanMaximumAmmount() {
	return loanMaximumAmmount;
}
public void setLoanMaximumAmmount(double loanMaximumAmmount) {
	this.loanMaximumAmmount = loanMaximumAmmount;
}
}
