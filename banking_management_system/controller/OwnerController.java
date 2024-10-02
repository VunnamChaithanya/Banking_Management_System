package com.qsp.banking_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Owner;
import com.qsp.banking_management_system.service.OwnerService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldId,@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldId, newOwner);
	}
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	@GetMapping("/fetchAllOwners")
	public ResponseStructureList<Owner> fetchAllOwners() {
		return ownerService.fetchAllOwners();
	}
	@PutMapping("/addExistingBankToExistingOwner")
	public ResponseStructure<Owner> addExistingBankToExistingOwner(@RequestParam int bankId,@RequestParam int ownerId) {
		return ownerService.addExistingBankToExistingOwner(bankId, ownerId);
	}
}
