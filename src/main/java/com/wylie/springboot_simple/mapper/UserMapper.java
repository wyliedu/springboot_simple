package com.wylie.springboot_simple.mapper;


import java.util.List;

import com.wylie.springboot_simple.entity.User;



public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}