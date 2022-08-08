package com.employee.test;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.serviceimpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeSystemApplicationTest {

	
	@Mock
	private EmployeeRepository employeeRepo;

	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();

	@BeforeEach
	void setMockOutput() {
		this.employeeService = new EmployeeServiceImpl(this.employeeRepo);
	}

	@Test
	void testRegisterEmployee() {
		Employee employee = new Employee();
		employee.setName("Akshay");
		employee.setGender("Male");
		employee.setAddress("Mumbai");
		employee.setUserName("akki");
		employee.setBasic(100000);

		int basic = 100000;
		float da = 0.2f * basic;
		float hra = 0.35f * basic;
		float pf = .1f * basic;

		float salary = basic + da + hra - pf;
		
		employee.setDa(da);
		employee.setHra(hra);
		employee.setPf(pf);
		employee.setSalary(salary);
		
		
		
		employeeService.registerEmployee(employee);
		verify(employeeRepo).save(employee);
	}

}
