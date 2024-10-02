package com.qsp.banking_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int bankId;
 private String bankName;
 private String bankIFSC;
 private long bankPhone;
 private String bankEmail;
 
 @OneToMany(cascade = CascadeType.ALL)
 private List<Branch> branches;

 @OneToMany(cascade = CascadeType.ALL)
 private List<Atm> atms;
 
public int getBankId() {
	return bankId;
}
public void setBankId(int bankId) {
	this.bankId = bankId;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getBankIFSC() {
	return bankIFSC;
}
public void setBankIFSC(String bankIFSC) {
	this.bankIFSC = bankIFSC;
}
public long getBankPhone() {
	return bankPhone;
}
public void setBankPhone(long bankPhone) {
	this.bankPhone = bankPhone;
}
public String getBankEmail() {
	return bankEmail;
}
public void setBankEmail(String bankEmail) {
	this.bankEmail = bankEmail;
}
public List<Branch> getBranches() {
	return branches;
}
public void setBranches(List<Branch> branches) {
	this.branches = branches;
}
public List<Atm> getAtms() {
	return atms;
}
public void setAtms(List<Atm> atms) {
	this.atms = atms;
}
 
}
