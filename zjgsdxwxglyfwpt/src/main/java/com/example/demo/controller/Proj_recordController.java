package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.Proj_record_List_of_items;
import com.example.demo.service.Proj_recordService;

@CrossOrigin
@RestController
public class Proj_recordController {
	@Autowired
	Proj_recordService proj_recordservice;
	@ResponseBody
	@RequestMapping(value="/msg/record",method= {RequestMethod.GET})
	public Proj_record_List_of_items findProj_recordByPage(int page) {
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
	     return proj_recordservice.findProj_recordByPage(pageParam);
	}
	@ResponseBody
	@RequestMapping(value="/msg/record/search",method= {RequestMethod.GET})
	public Proj_record_List_of_items findProj_recordDaoByPageAndNumber(int page,String number) {
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
	     return proj_recordservice.findProj_recordDaoByPageAndNumber(pageParam, number);
	}
	@ResponseBody
	@RequestMapping(value="/record/number",method= {RequestMethod.POST})
	Proj_record_List_of_items updateProj_record(String number_record,String number_record_hall,String number) {
		PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(1);
	     return proj_recordservice.updateProj_record(number_record, number_record_hall, number, pageParam);
	     
	}
}
