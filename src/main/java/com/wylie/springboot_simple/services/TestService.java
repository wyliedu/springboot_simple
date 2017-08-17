package com.wylie.springboot_simple.services;

import org.springframework.stereotype.Service;

import com.wylie.common.service.ITestService;

@Service
public class TestService implements ITestService{

	@Override
	public String sayHello(String name) {
		return "Hello World! " + name;
	}

}
