package com.wylie.springboot_simple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 启动项目之后执行自己要执行的东西的实现方法
 * @author 13612
 *
 */
@Configuration
public class BeforeStartup implements ApplicationListener<ContextRefreshedEvent> {
 
	@Autowired
	private InitDB initDB;
 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initDB.createUser();
	}
 
}
