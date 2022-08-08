package com.employee.entity;

public class Admin extends User {

	private String designation;

	public Admin() {
		super();
	}

	public Admin(String designation) {
		super();
		this.designation = designation;
	}

	public Admin(int userId, String name, String gender, String address, String email, String userName,
			String password) {
		super(userId, name, gender, address, email, userName, password);
		// TODO Auto-generated constructor stub
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Admin [designation=" + designation + "]";
	}	
}