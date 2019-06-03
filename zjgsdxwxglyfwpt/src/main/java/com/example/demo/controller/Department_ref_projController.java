package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.service.Department_ref_projService;

@RestController
public class Department_ref_projController {
	@Autowired
	Department_ref_projService department_ref_projservice;
	@ResponseBody
	 @RequestMapping(value="/msg/ref",method= {RequestMethod.GET})
	public List_of_items findByStatusAndPage(@RequestParam int page,@RequestParam String status)
	{
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
		return department_ref_projservice.findDeclarationByStatus(status, pageParam);
	}
}
