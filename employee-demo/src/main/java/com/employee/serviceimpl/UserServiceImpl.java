package com.employee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.User;
import com.employee.repository.UserRepository;
import com.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User login(String userName, String password) {
		User user = userRepository.findByUserNameAndPassword(userName, password);
		
		return user;
	}

}
