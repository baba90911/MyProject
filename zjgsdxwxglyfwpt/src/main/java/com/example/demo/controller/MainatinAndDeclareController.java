package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.AcceptList;
import com.example.demo.pojo.RESTful.AcceptTable;
import com.example.demo.pojo.RESTful.DeclareTable;
import com.example.demo.pojo.RESTful.MaintainList;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.service.MainatinAndDeclareService;

@CrossOrigin
@RestController
public class MainatinAndDeclareController {
	@Autowired
	MainatinAndDeclareService mainatinAnddeclareservice;
	
	@ResponseBody
	@RequestMapping(value="/repairs",method= {RequestMethod.POST})
	public ResponseMessage maintenanceReport(String projNum,String name,String department ,String linkman,String phone,String content,MultipartFile  attach,String location) {
		return mainatinAnddeclareservice.maintenanceReport(projNum, name, department, linkman, phone, content, attach, location);
	}
	
	@ResponseBody
	@RequestMapping(value="/repairs/detail",method= {RequestMethod.GET})
	public DeclareTable findMaintainDetailByprojNum(String number_req) {
		return mainatinAnddeclareservice.findMaintainDetailByprojNum(number_req);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/repairs1",method= {RequestMethod.GET})
	public MaintainList findMaintainListByPage(int page) {
		PageParam pageParam = new PageParam();
	    pageParam.setCurrPage(page);
	    return  mainatinAnddeclareservice.findMaintainListByPage(pageParam);
	}
	
	@ResponseBody
	@RequestMapping(value="/repairs/accept",method= {RequestMethod.GET})
	public AcceptList findAcceptListByPageAndStatus(String status,int page) {
		PageParam pageParam = new PageParam();
	    pageParam.setCurrPage(page);
	    return mainatinAnddeclareservice.findAcceptListByPageAndStatus(status, pageParam);
	}
	
	@ResponseBody
	@RequestMapping(value="/repairs/accept/detail",method= {RequestMethod.GET})
	public DeclareTable findAcceptDetailByprojNum(String number_req) {
		return mainatinAnddeclareservice.findMaintainDetailByprojNum(number_req);
	}
	
	@ResponseBody
	@RequestMapping(value="/operation/repairs/accept",method= {RequestMethod.POST})
	ResponseMessage acceptTable(String name,String date,String content,String material,String amount,String operation ,String projNum) {
		return mainatinAnddeclareservice.acceptTable(name, date, content, material, amount, operation, projNum);
	}
	
	@ResponseBody
	@RequestMapping(value="/operation/repairs/refuse",method= {RequestMethod.POST})
	public ResponseMessage refuseTable(String operation,String projNum,String reason) {
		return mainatinAnddeclareservice.refuseTable(operation, projNum, reason);
	}
	
	@ResponseBody
	@RequestMapping(value="/print/repairs/accept",method= {RequestMethod.GET})
	public AcceptTable  printAcceptTable(String projNum) {
		return mainatinAnddeclareservice.printAcceptTable(projNum);
	}
}
