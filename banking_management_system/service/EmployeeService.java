package com.qsp.banking_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.EmployeeDao;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	@Autowired 
	ResponseStructureList<Employee> responseStructureList;
	
	public ResponseStructure<Employee>  saveEmployee(Employee  employee) {
		responseStructure.setMessage("Successfully employee inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;
	}
	public ResponseStructure<Employee>  fetchEmployeeById(int employeeId) {
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(employee != null) {
			responseStructure.setMessage("Successfully employee fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return responseStructure;
		}
		else {
		    throw new EmployeeIdNotFound();
		}
		
	}
	public ResponseStructure<Employee>  updateEmployeeById(int oldId,Employee newEmployee) {
		Employee employee=employeeDao.fetchEmployeeById(oldId);
		if(employee != null) {
		responseStructure.setMessage("Successfully employee updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.upateEmployeeById(oldId, newEmployee));
		return responseStructure;
		}else {
		    throw new EmployeeIdNotFound();
		}
	}
	public ResponseStructure<Employee>  deleteEmployeeById(int employeeId) {
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(employee != null) {
		responseStructure.setMessage("Successfully employee deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
		return responseStructure;
		}
		else {
		    throw new EmployeeIdNotFound();
		}
	}
	public ResponseStructureList<Employee> fetchAllEmployee(){
		responseStructureList.setMessage("Successfully fetched all employees from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(employeeDao.fetchAllEmployee());
	    return responseStructureList ;
	}
}
