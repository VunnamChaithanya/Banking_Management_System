package com.qsp.banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.service.BankService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@RestController
public class BankController {
	@Autowired
	BankService bankService;
	
	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}
	@PutMapping("/updateBankById")
	public ResponseStructure<Bank> updateBankById(@RequestParam int oldId,@RequestBody Bank newBank) {
		return bankService.updateBankById(oldId, newBank);
	}
	@DeleteMapping("/deleteBankById")
	public ResponseStructure<Bank> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}
	@GetMapping("/fetchAllBanks")
	public ResponseStructureList<Bank> fetchAllBanks() {
		return bankService.fetchAllBanks();
	}
//	@PutMapping("/addExistingBranchesToExistingBank")
//	public Bank addExistingBranchesToExistingBank(@RequestParam int bankId){
//		return bankService.addExistingBranchesToExistingBank(bankId);
//	}
	@PutMapping("/addExistingBranchesToExistingBank")
	public ResponseStructure<Bank> addExistingBranchToExistingBank(@RequestParam int branchId,@RequestParam int bankId) {
		return bankService.addExistingBranchToExistingBank(branchId, bankId);
	}
	@PutMapping("/addnewBranchToExistingBank")
	public ResponseStructure<Bank> addNewBranchToExistingBank(@RequestParam int bankId ,@RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}
	@PutMapping("/addExistingAtmToExistingBank")
	public ResponseStructure<Bank> addExistingAtmToExistingBank(@RequestParam int bankId,@RequestParam int atmId) {
		return bankService.addExistingAtmToExistingBank(bankId, atmId);
	}
	@PutMapping("/addNewAtmToExistingBank")
	public ResponseStructure<Bank> addNewAtmToExistingBank(@RequestParam int bankId,@RequestBody Atm newAtm) {
		return bankService.addNewAtmToExistingBank(bankId, newAtm);
	}
}
