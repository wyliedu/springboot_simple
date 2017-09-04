package com.wylie.springboot_simple.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wylie.common.service.ITestService;
import com.wylie.springboot_simple.entity.User;
import com.wylie.springboot_simple.mapper.UserMapper;
import com.wylie.springboot_simple.model.mongodb.DemoInfo;
import com.wylie.springboot_simple.services.DemoInfoRepository;


@RestController
public class TestController{
	
	@Autowired
	private ITestService testService;
	
	@Autowired
	private UserMapper userMapper;
	
    @Autowired
    private DemoInfoRepository demoInfoRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
	
    @RequestMapping("/hi")
	public String hello() {
    	String result = this.testService.sayHello("wylie");
    	System.out.println(result);
    	return result;
	}

/*    @Cacheable(value="user-key",key="'allUser'")
    @RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		System.out.println("测试缓存");
		return users;
	}
	
    @RequestMapping("/getUser")
    public User getUser(Integer id) {
    	User user=userMapper.getOne(id);
        return user;
    }*/
    
    @RequestMapping("/add")
    public void save(User user) {
    	userMapper.insert(user);
    }
    
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
    	userMapper.deleteByPrimaryKey(id);
    }
   
    @RequestMapping(value="save",method=RequestMethod.POST)
    public String save(){
       DemoInfo demoInfo = new DemoInfo();
       demoInfo.setName("张三");
       demoInfo.setAge(20);
       demoInfoRepository.save(demoInfo);
      
       demoInfo = new DemoInfo();
       demoInfo.setName("李四");
       demoInfo.setAge(30);
       demoInfoRepository.save(demoInfo);
      
       return "ok";
    }
   
    @RequestMapping(value="find",method=RequestMethod.GET)
    public List<DemoInfo> find(){
       return demoInfoRepository.findAll();
    }
   
    @RequestMapping(value="findByName",method=RequestMethod.GET)
    public DemoInfo findByName(){
       return demoInfoRepository.findByName("张三");
    }
    
    @RequestMapping(value="find2",method=RequestMethod.GET)
    public List<DemoInfo> find2(){
       return mongoTemplate.findAll(DemoInfo.class);
    }
}