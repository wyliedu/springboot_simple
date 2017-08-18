package com.wylie.springboot_simple.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wylie.springboot_simple.entity.User;
import com.wylie.springboot_simple.exception.NotFoundException;
import com.wylie.springboot_simple.mapper.UserMapper;

@Service
public class UserService {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

	
	@Transactional
    public void addUserTo2Db(User user) {
    	userMapper.insert(user);
    	if (true) {
			throw new NotFoundException("9000", "eee");
		}
    }
	
	public User findByUsername(String username){
		return this.userMapper.findByUsername(username);
	}
}
