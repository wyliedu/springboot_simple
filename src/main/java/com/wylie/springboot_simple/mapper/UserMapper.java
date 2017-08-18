package com.wylie.springboot_simple.mapper;

import org.apache.ibatis.annotations.Options;

import com.wylie.springboot_simple.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    //@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findByUsername(String username);
}