package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RequestMapping("/test")
@RestController
public class UserController {
	 @Autowired 
	 private UserService userservice;
	@PostMapping("/manager_login")
	public Object login(int id,String password,int type) throws Exception {
		Object i;

		i=userservice.login(id, password, type);
		return i;
	}

	
}
