package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.RESTful.DepartmentList;
import com.example.demo.service.Department_messageService;

@CrossOrigin
@RestController
public class Department_messageController {
	@Autowired
	Department_messageService department_messageservice;
	
	@ResponseBody
	@RequestMapping(value="/department",method= {RequestMethod.GET})
	public DepartmentList findAllDepartment() {
		return department_messageservice.findAllDepartment();
	}
}
