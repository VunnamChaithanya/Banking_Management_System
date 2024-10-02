package com.qsp.banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.service.BranchService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldId,@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldId, newBranch);
	}
	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	@GetMapping("/fetchAllBranchs")
	public ResponseStructureList<Branch> fetchAllBranchs() {
		return branchService.fetchAllBranchs();
	}
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId ,@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int addressId ,@RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(@RequestParam int employeeId ,@RequestParam int branchId) {
		return branchService.addExistingEmployeeToExistingBranch(employeeId, branchId);
	}
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(@RequestParam int branchId ,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}
	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(@RequestParam int customerId ,@RequestParam int branchId) {
		return branchService.addExistingCustomerToExistingBranch( customerId, branchId);
	}
	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(@RequestParam int branchId ,@RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newCustomer);
	}
}
