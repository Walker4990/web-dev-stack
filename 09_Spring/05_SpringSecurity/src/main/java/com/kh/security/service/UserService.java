package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public void register(User user) {
		mapper.register(user);
	}
	
	public User login(String id) {
		return mapper.login(id);
	}
	
}
