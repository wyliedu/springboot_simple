package com.wylie.springboot_simple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wylie.springboot_simple.entity.User;
import com.wylie.springboot_simple.services.UserService;

@Component
public class InitDB {

	@Autowired
	private UserService userService;

	// create user
	public void createUser() {
		userService.findByUsername("a");
	}
}
