package com.qsp.banking_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AddressDao;
import com.qsp.banking_management_system.dao.BranchDao;
import com.qsp.banking_management_system.dao.CustomerDao;
import com.qsp.banking_management_system.dao.EmployeeDao;
import com.qsp.banking_management_system.dao.ManagerDao;
import com.qsp.banking_management_system.dto.Address;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.dto.Manager;
import com.qsp.banking_management_system.exception.AddressIdNotFound;
import com.qsp.banking_management_system.exception.BranchIdNotFound;
import com.qsp.banking_management_system.exception.CustomerIdNotFound;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.exception.ManagerIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	AddressDao addressDao;
    @Autowired
    EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;
	public ResponseStructure<Branch>  saveBranch(Branch  branch) {
		responseStructure.setMessage("Successfully branch inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;	
	}
	public ResponseStructure<Branch>  fetchBranchById(int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("Successfully branch fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return responseStructure;
		}
		else {
			throw new BranchIdNotFound();
		}
	}
		
	public ResponseStructure<Branch>  updateBranchById(int oldId,Branch newBranch) {
		Branch branch=branchDao.fetchBranchById(oldId);
		if(branch != null) {
		responseStructure.setMessage("Successfully branch updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.upateBranchById(oldId, newBranch));
		return responseStructure;
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	public ResponseStructure<Branch>  deleteBranchById(int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("Successfully branch deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return responseStructure;	
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	public ResponseStructureList<Branch> fetchAllBranchs(){
		responseStructureList.setMessage("Successfully fetched all branches from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllBranchs());
	    return responseStructureList ;
	}
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId ,int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		Manager manager=managerDao.fetchManagerById(managerId);
		if(branch != null) {
			if(manager!=null) {
		responseStructure.setMessage("Successfully added ExistingManagerToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return responseStructure;
		    }else {
		    	throw new ManagerIdNotFound();
		          }
		}else {
			throw new BranchIdNotFound();
		}
	}
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId , int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		if(branch != null) {
			if(address!=null) {
		responseStructure.setMessage("Successfully added ExistingAddressToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId , branchId));
		return responseStructure;
	       }else {
	    	   throw new AddressIdNotFound();
	       }
		}else {
			throw new BranchIdNotFound();
		}
	}	
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(int employeeId , int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
        Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(branch != null) {
			if(employee!=null) {
		responseStructure.setMessage("Successfully added ExistingEmployeeToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(employeeId, branchId));
		return responseStructure;
			}else {
				 throw new EmployeeIdNotFound();
		       }
			}
		else {
			 throw new BranchIdNotFound();	
		}
	}
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch( int branchId , Employee newEmployee) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("Successfully added NewEmployeeToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee));
		return responseStructure;
		}else {
			 throw new BranchIdNotFound();	
		}
	}
	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(int customerId , int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
        Customer customer=customerDao.fetchCustomerById(customerId);
		if(branch != null) {
			if(customer!=null) {
		responseStructure.setMessage("Successfully added ExistingCustomerToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingCustomerToExistingBranch( customerId, branchId));
		return responseStructure;
			}
			else {
			     	throw new CustomerIdNotFound();	
			     }
		}
		else {
			throw new BranchIdNotFound();	
		}
	}
	public ResponseStructure<Branch> addNewCustomerToExistingBranch( int branchId , Customer newCustomer) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("Successfully added NewCustomerToExistingBranch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData( branchDao.addNewCustomerToExistingBranch(branchId, newCustomer));
		return responseStructure;
	    }
		else {
			throw new BranchIdNotFound();	
		}
	}
}
