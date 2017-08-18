package com.wylie.springboot_simple.mapper;

import java.util.List;

import com.wylie.springboot_simple.entity.Authority;
import com.wylie.springboot_simple.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> getRoleList(Integer userId);
    
    List<String> getAuthorityList(Integer roleId);
}