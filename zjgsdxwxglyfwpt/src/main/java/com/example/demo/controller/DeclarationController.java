package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Declaration;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.DeclarationRestful;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.service.DeclarationService;



@RestController
public class DeclarationController {
	 @Autowired 
	 private DeclarationService   declarationservice;
	 @PostMapping("/declare1")
	 public ResponseMessage insertdeclaration(@RequestBody Declaration dec) {
		 ResponseMessage mec=new ResponseMessage();
		 if(declarationservice.insertdeclaration(dec)) {
			 mec.setCode(200);
			 mec.setMsg("申报提交成功");
		 }
		 else {
			mec.setCode(500);
		 	mec.setMsg("申报提交失败");
		 }
			return mec; 
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/declare",method= {RequestMethod.GET})
		public List_of_items  pagingquery(@RequestParam int page,@RequestParam int type) {
		 PageParam pageParam = new PageParam();
	     pageParam.setCurrPage(page);
		 return declarationservice.findDeclarationByType(type,pageParam);
	}
	 @GetMapping("/declare/detail")
		public DeclarationRestful  pagingquery(String reqNum) {
		 return declarationservice.findDeclarationByReqNum(reqNum);
	}
}
