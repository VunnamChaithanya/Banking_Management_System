package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.repo.BankRepo;
@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	AtmDao atmDao;
	
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}
	public Bank fetchBankById(int bankId) {
	Optional<Bank> bank= bankRepo.findById(bankId);
	if(bank.isPresent()) {
	    return bank.get();
	}
	else {
		return null;
	}
	}
	public Bank upateBankById(int oldId, Bank newBank) {
		newBank.setBankId(oldId);
		return bankRepo.save(newBank);
	}
	public Bank deleteBankById(int bankId) {
		Bank bank=bankRepo.findById(bankId).get();
		bankRepo.delete(bank);
		return bank;
	}
	public List<Bank> fetchAllBanks() {
		return bankRepo.findAll();
	}
//    public Bank addExistingBranchesToExistingBank(int bankId){
//    	Bank bank=fetchBankById(bankId);
//    	List<Branch> branches=branchDao.fetchAllBranchs();
//    	bank.setBranches(branches);
//        return saveBank(bank);   	
//    }
	public Bank addExistingBranchToExistingBank(int branchId,int bankId) {
		Bank bank=fetchBankById(bankId);
		Branch branch=branchDao.fetchBranchById(branchId);
		List<Branch> list=bank.getBranches();
		list.add(branch);
		bank.setBranches(list);
		return saveBank(bank);
	}
	
	public Bank addNewBranchToExistingBank(int bankId , Branch newBranch) {
		Bank bank=fetchBankById(bankId);
		List<Branch> list=bank.getBranches();
		list.add(newBranch);
		bank.setBranches(list);
		return saveBank(bank);
	}
	public Bank addExistingAtmToExistingBank(int bankId,int atmId) {
		Bank bank=fetchBankById(bankId);
		Atm atm=atmDao.fetchAtmById(atmId);
		List<Atm> list=bank.getAtms();
		list.add(atm);
		bank.setAtms(list);
		return saveBank(bank);
	}
	public Bank addNewAtmToExistingBank(int bankId,Atm newAtm) {
		Bank bank=fetchBankById(bankId);
		List<Atm> list=bank.getAtms();
		list.add(newAtm);
		bank.setAtms(list);
		return saveBank(bank);
	}
}
