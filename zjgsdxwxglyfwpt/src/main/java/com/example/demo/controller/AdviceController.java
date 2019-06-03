package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.RESTful.AdviceItems;
import com.example.demo.service.AdviceService;

@CrossOrigin
@RestController
public class AdviceController {
	
	
	@Autowired
	AdviceService adviceservice;
	
	@ResponseBody
	@RequestMapping(value="/advice",method= {RequestMethod.DELETE})
	public AdviceItems findAdviceByNumAndName(String number ,String dptName) {
		return adviceservice.findAdviceByNumAndName(number, dptName);
		
	}
	

}
