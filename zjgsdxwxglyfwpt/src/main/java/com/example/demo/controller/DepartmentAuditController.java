package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.service.DepartmentAuditService;

@RestController
public class DepartmentAuditController {
	@Autowired
	DepartmentAuditService departmentauditservice;
	@ResponseBody
	 @RequestMapping(value="/operation/dpt",method= {RequestMethod.POST})
	public ResponseMessage firstTrial(String operation, String advice, String reqNum) {
		return departmentauditservice.firstTrial(operation, advice, reqNum);
	}
	@ResponseBody
	 @RequestMapping(value="/operation/pao/no",method= {RequestMethod.POST})
	public ResponseMessage PaoFirstTrial(String operation, String advice, String budget, String reqNum, ArrayList<String> list) {
		return departmentauditservice.PaoFirstTrial(operation, advice, budget, reqNum, list);
	}
	@ResponseBody
	 @RequestMapping(value="/operation/pao/yes",method= {RequestMethod.POST})
	public ResponseMessage PaoSendList(String reqNum, String finallocation) {
		return departmentauditservice.PaoSendList(reqNum, finallocation);
	}
	@ResponseBody
	 @RequestMapping(value="/operation/ref",method= {RequestMethod.POST})
	public ResponseMessage refTrial(String operation,String advice,String reqNum) {
		return departmentauditservice.refTrial(operation, advice, reqNum);
	}
}
