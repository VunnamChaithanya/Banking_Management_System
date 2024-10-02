package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.repo.EmployeeRepo;
@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee fetchEmployeeById(int employeeId) {
	Optional<Employee>	employee= employeeRepo.findById(employeeId);
	if(employee.isPresent()) {
		return employee.get();
	}
	else {
		return null;
	}
	}
	public Employee upateEmployeeById(int oldId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldId);
		return employeeRepo.save(newEmployee);
	}
	public Employee deleteEmployeeById(int employeeId) {
		Employee employee=employeeRepo.findById(employeeId).get();
		employeeRepo.delete(employee);
		return employee;
	}
	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}
}
