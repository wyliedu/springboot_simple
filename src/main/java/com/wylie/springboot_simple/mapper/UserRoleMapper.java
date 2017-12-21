package com.wylie.springboot_simple.mapper;

import java.util.List;

import com.wylie.springboot_simple.entity.Role;
import com.wylie.springboot_simple.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    List<Role> getRoleListByUserId(Long userId);
}