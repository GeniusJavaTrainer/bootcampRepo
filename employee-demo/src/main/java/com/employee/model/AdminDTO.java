package com.employee.model;

import javax.validation.constraints.NotNull;

public class AdminDTO extends UserDTO {
	
	@NotNull
	private String designation;

	public AdminDTO() {
		super();
	}

	public AdminDTO(int userId, String name, String gender, String address, String email, String userName,
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
		return "AdminDTO [designation=" + designation + "]";
	}
}