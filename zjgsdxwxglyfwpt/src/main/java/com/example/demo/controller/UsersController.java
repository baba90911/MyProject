package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.Allpermessions;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.pojo.RESTful.UsersPermisssionsItems;
import com.example.demo.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {
	@Autowired
	UsersService usersservice;
	@ResponseBody
	@RequestMapping(value="/list/role",method= {RequestMethod.DELETE})
	public ResponseMessage deleteuserByusername(String username) {
		return usersservice.deleteuserByusername(username);
	}
	
	@ResponseBody
	@RequestMapping(value="/list/role/reset",method= {RequestMethod.POST})
	public ResponseMessage initializingPwd(String username) {
		return usersservice.initializingPwd(username);
	}
	
	@ResponseBody
	@RequestMapping(value="/list/role1",method= {RequestMethod.POST})
	public ResponseMessage updatePermissions(String username,ArrayList<String> list) {
		list.add("fa");
		list.add("haha ");
		list.add("234");
		return usersservice.updatePermissions(username, list);
	}
	
	@ResponseBody
	@RequestMapping(value="/list/role2",method= {RequestMethod.GET})
	public UsersPermisssionsItems findUsersByPage(int page) {
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
	     return usersservice.findUsersByPage(pageParam);
	}
	

	@ResponseBody
	@RequestMapping(value="/list/role/name",method= {RequestMethod.GET})
	public Allpermessions  findAllPermission() {
		return usersservice.findAllPermission();
	}
	
}
