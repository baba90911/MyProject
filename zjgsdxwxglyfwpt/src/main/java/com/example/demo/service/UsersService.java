package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.Allpermessions;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.pojo.RESTful.UsersPermisssionsItems;

public interface UsersService {
	public ResponseMessage deleteuserByusername(String username);
	public ResponseMessage initializingPwd(String username);
	public ResponseMessage updatePermissions(String username,ArrayList<String> list);
	public UsersPermisssionsItems findUsersByPage(PageParam pageParam);
	public Allpermessions  findAllPermission();
}
