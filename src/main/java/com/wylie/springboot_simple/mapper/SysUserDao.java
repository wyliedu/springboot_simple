package com.wylie.springboot_simple.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author wangyong
 * @email wangyong@gmail.com
 * @date 2017年8月28日 上午9:34:11
 */
@Mapper
public interface SysUserDao {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	int queryAllMenuId();
	
	
}
