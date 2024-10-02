package com.qsp.banking_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.BankDao;
import com.qsp.banking_management_system.dao.OwnerDao;
import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Owner;
import com.qsp.banking_management_system.exception.BankIdNotFound;
import com.qsp.banking_management_system.exception.OwnerIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class OwnerService {
 
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	@Autowired
	BankDao bankDao;
	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setMessage("Successfully owner inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
	}
	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
			responseStructure.setMessage("Successfully owner fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.saveOwner(ownerDao.fetchOwnerById(ownerId)));
		   return responseStructure ;
		}
		else {
			throw new OwnerIdNotFound();
		}	
	}
	public ResponseStructure<Owner> updateOwnerById(int oldId,Owner newOwner) {
		Owner owner=ownerDao.fetchOwnerById(oldId);
		if(owner!=null) {
		responseStructure.setMessage("Successfully owner updated from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.saveOwner(ownerDao.upateOwnerById(oldId, newOwner)));
	    return responseStructure ;
	         }
		else {
			throw new OwnerIdNotFound();
		}
	}
	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
	    Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setMessage("Successfully owner deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.saveOwner(ownerDao.deleteOwnerById(ownerId)));
	    return responseStructure ;
	     }
	    else {
			throw new OwnerIdNotFound();
		}	
}
	public ResponseStructureList<Owner> fetchAllOwners(){
		responseStructureList.setMessage("Successfully fetched all owners from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(ownerDao.fetchAllOwners());
	    return responseStructureList ;
	}	
	public ResponseStructure<Owner> addExistingBankToExistingOwner(int bankId,int ownerId) {
		 Owner owner=ownerDao.fetchOwnerById(ownerId);
		 Bank bank=bankDao.fetchBankById(bankId);
			if(owner!=null) {
				if(bank!=null) {
					responseStructure.setMessage("Successfully added ExistingBankToExistingOwner from DB");
					responseStructure.setStatusCode(HttpStatus.OK.value());
					responseStructure.setData(ownerDao.addExistingBankToExistingOwner(bankId, ownerId));
				    return responseStructure ;
				}
				else {
					throw new BankIdNotFound();
				}
			}else {
				throw new OwnerIdNotFound();
			}
		
		
	}
}
