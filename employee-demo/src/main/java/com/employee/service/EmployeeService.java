package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.EmployeeDTO;

public interface EmployeeService {

	public String registerEmployee(Employee employee);

	public String updateEmployee(Employee employer) throws EmployeeNotFoundException;
	
	public String deleteEmployee(int employeeId) throws EmployeeNotFoundException;
	
	public EmployeeDTO getEmployee(int employeeId) throws EmployeeNotFoundException;
	
	public List<EmployeeDTO>getEmployees();
}