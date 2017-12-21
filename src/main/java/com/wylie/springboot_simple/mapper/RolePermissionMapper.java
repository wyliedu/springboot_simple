package com.wylie.springboot_simple.mapper;

import java.util.List;

import com.wylie.springboot_simple.entity.Permission;
import com.wylie.springboot_simple.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
    
    List<String> getPermissionByRoleId(Long roleId);
}