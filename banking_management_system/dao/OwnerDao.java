package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Owner;
import com.qsp.banking_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	BankDao bankDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner= ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}else {
			return null;
		}
	}
	public Owner upateOwnerById(int oldId, Owner newOwner) {
		newOwner.setOwnerId(oldId);
		return ownerRepo.save(newOwner);
	}
	public Owner deleteOwnerById(int ownerId) {
		Owner owner=ownerRepo.findById(ownerId).get();
		ownerRepo.delete(owner);
		return owner;
	}
	public List<Owner> fetchAllOwners() {
		return ownerRepo.findAll();
	}
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		Bank bank=bankDao.fetchBankById(bankId);
		Owner owner=fetchOwnerById(ownerId);
		owner.setBank(bank);
		return saveOwner(owner);	
	}
}
