package com.qsp.banking_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.ManagerDao;
import com.qsp.banking_management_system.dto.Manager;
import com.qsp.banking_management_system.exception.ManagerIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager  manager) {
		responseStructure.setMessage("Successfully manager inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}
	public ResponseStructure<Manager>  fetchManagerById(int managerId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager != null) {
			responseStructure.setMessage("Successfully manager fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return responseStructure;
		}
		else {
			throw new ManagerIdNotFound();
		}
		}
	public ResponseStructure<Manager>  updateManagerById(int oldId,Manager newManager) {
		Manager manager=managerDao.fetchManagerById(oldId);
		if(manager != null) {
		responseStructure.setMessage("Successfully manager updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.upateManagerById(oldId, newManager));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}
	public ResponseStructure<Manager>  deleteManagerById(int managerId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager != null) {
		responseStructure.setMessage("Successfully manager deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return responseStructure;
		}
		else {
			throw new ManagerIdNotFound();
		}
	}
	public ResponseStructureList<Manager> fetchAllManagers(){
		responseStructureList.setMessage("Successfully fetched all managers from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(managerDao.fetchAllManagers());
	    return responseStructureList ;
	}
}
