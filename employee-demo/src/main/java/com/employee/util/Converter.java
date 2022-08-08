package com.employee.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.employee.entity.Employee;
import com.employee.model.EmployeeDTO;

@Component
public class Converter {

	public Employee convertToEmployeeEntity(EmployeeDTO employeeDTO) {
		Employee employee =new Employee();
				
		if(employeeDTO != null) {
			BeanUtils.copyProperties(employeeDTO, employee);
		}
		
		return employee;
	}
	
	public EmployeeDTO convertToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO=new EmployeeDTO();
		
		if(employee != null) {
			BeanUtils.copyProperties(employee, employeeDTO);			
		}
		
		return employeeDTO;
	}
}