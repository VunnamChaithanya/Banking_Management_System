package com.qsp.banking_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AddressDao;
import com.qsp.banking_management_system.dto.Address;
import com.qsp.banking_management_system.exception.AddressIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired 
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address>  saveAddress(Address  address) {
		responseStructure.setMessage("Successfully address inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
		}
	public ResponseStructure<Address>  fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address != null) {
		responseStructure.setMessage("Successfully address fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseStructure<Address>  updateAddressById(int oldId,Address newAddress) {
		Address address=addressDao.fetchAddressById(oldId);
		if(address != null) {
		responseStructure.setMessage("Successfully address updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.upateAddressById(oldId, newAddress));
		return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseStructure<Address>  deleteAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address != null) {
		responseStructure.setMessage("Successfully address deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseStructureList<Address> fetchAllAddresss(){
		responseStructureList.setMessage("Successfully fetched all addresses from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(addressDao.fetchAllAddresss());
	    return responseStructureList ;
	}
}
