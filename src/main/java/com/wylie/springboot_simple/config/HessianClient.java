package com.wylie.springboot_simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.wylie.common.service.ITestService;

@Configuration
public class HessianClient {

	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8092/HelloWorldService");
		factory.setServiceInterface(ITestService.class);
		return factory;
	}
}
