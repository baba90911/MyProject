package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Users;

public interface UsersDao {
	public  void deleteuserByusername(@Param("username")String username);
	public void  initializingPwd(String username);
	public void updatePermissions(Map<String,Object> map);
	public  List<Users> findUsersByPage(Map<String,Object> map);
	public int getRowCountByPage();
    public String findAllPermission();
    
}
