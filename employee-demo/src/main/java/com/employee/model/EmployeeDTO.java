package com.employee.model;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDTO extends UserDTO {
	
	@Min(value=20000)
	private int basic;
	
	private float da;
	private float hra;
	private float pf;
	private float salary;
	
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(@Min(20000) int basic, float da, float hra, float pf, float salary) {
		super();
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		this.pf = pf;
		this.salary = salary;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public float getDa() {
		return da;
	}

	public void setDa(float da) {
		this.da = da;
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	public float getPf() {
		return pf;
	}

	public void setPf(float pf) {
		this.pf = pf;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [basic=" + basic + ", da=" + da + ", hra=" + hra + ", pf=" + pf + ", salary=" + salary
				+ "]";
	}
}