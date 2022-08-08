package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.model.EmployeeDTO;
import com.employee.service.EmployeeService;
import com.employee.util.Converter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController(value = "/secure")
@RequestMapping("/secure")
@Api( tags = "Clients")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Converter converter;
	
	@GetMapping("/getmessage")
	public String getMessage() {
		return "Login successful";
	}
	
	@ApiOperation(value = "This method is used to register employees.")
	@PostMapping(value = "/registeremployee")
	public String registerEmployee(@RequestBody final EmployeeDTO employeeDTO) {
		final Employee employee = converter.convertToEmployeeEntity(employeeDTO);
		return employeeService.registerEmployee(employee);
	}
	
	@PutMapping(value = "/updateemployee")
	public String updateEmployee(@RequestBody final EmployeeDTO employeeDTO) {
		final Employee employee = converter.convertToEmployeeEntity(employeeDTO);
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value = "/deleteemployee/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") final int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping(value = "/getemployee/{employeeId}")
	public EmployeeDTO getEmployee(@PathVariable("employeeId") final int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping(value = "/getallemployees")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getEmployees();
	}
}