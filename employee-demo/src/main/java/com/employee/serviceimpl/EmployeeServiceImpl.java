package com.employee.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.EmployeeDTO;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.util.Converter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private Converter converter;

//	@Autowired
//	private UserRepository userRepo;

	public EmployeeServiceImpl() {
		super();
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	
	public EmployeeServiceImpl(EmployeeRepository employeeRepo, Converter converter) {
		super();
		this.employeeRepo = employeeRepo;
		this.converter = converter;
	}

	@Override
	public String registerEmployee(Employee employee) {
		String message = null;
		
		int basic = employee.getBasic();
		float da = 0.2f * basic;
		float hra = 0.35f * basic;
		float pf = .1f * basic;

		float salary = basic + da + hra - pf;

		employee.setDa(da);
		employee.setHra(hra);
		employee.setPf(pf);
		employee.setSalary(salary);

		employee = employeeRepo.save(employee);

		if (employee != null) {
			message = "Registration successful.";
		}
		return message;
	}

	@Override
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> empl = employeeRepo.findById(employee.getUserId());

		Employee emp = null;
		String message = null;

		if (empl.isPresent()) {
			
			emp = employeeRepo.save(empl.get());

			if (emp != null) {
				message = new String("Record updated successfully.");
			}
		} else {
			throw new EmployeeNotFoundException("No such Employee");
		}

		return message;
	}

	@Override
	public String deleteEmployee(int employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepo.findById(employeeId);

		String message = null;

		if (employee.isPresent()) {
			employeeRepo.deleteById(employeeId);

			message = new String("Record deleted successfully.");
		} else {
			throw new EmployeeNotFoundException("No such Employee");
		}

		return message;
	}

	@Override
	public EmployeeDTO getEmployee(int employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepo.findById(employeeId);

		Employee empl = null;

		if (employee.isPresent()) {
			empl = employee.get();
		} else {
			throw new EmployeeNotFoundException("No such Employee");
		}

		return converter.convertToEmployeeDTO(empl);
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		List<Employee> employees = employeeRepo.findAll();

		List<EmployeeDTO> employeeDTOs = new ArrayList<>();

		for (Employee employee : employees) {
			employeeDTOs.add(converter.convertToEmployeeDTO(employee));
		}
		return employeeDTOs;
	}
}