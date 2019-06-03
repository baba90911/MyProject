package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.service.Department_fist_projService;

@RestController
public class Department_first_projController {
	@Autowired
	private Department_fist_projService department_fist_projservice;
	
	@ResponseBody
	 @RequestMapping(value="/msg/dpt",method= {RequestMethod.GET})
	public List_of_items findByStatusAndPage(@RequestParam int page,@RequestParam String status)
	{
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
		return department_fist_projservice.findDeclarationByStatus(status, pageParam);
	}
}
