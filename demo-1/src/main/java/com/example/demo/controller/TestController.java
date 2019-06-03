package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Test;
import com.example.demo.service.TestService;
@RequestMapping("/test")
@RestController
public class TestController {
	@Autowired
	TestService testservice;
	@PostMapping("/score")
	public int count(@RequestBody ArrayList<Test> t) throws Exception {
		System.out.println(t);
		System.out.println(t.size());
		for(int i=0;i<t.size();i++) {
			System.out.println(t.get(i).getPaddress());
			System.out.println(t.get(i).getSclass());
			System.out.println(t.get(i).getSname());
			System.out.println(t.get(i).getTid());
		}
		int i=testservice.count(t);
		System.out.println(i);
		return i;
	}
	@GetMapping(value="/answer",produces="application/json;charset=utf-8")
	public List<String> givePictureurl(int id) throws Exception{
		List<String> list =new ArrayList<>();
		list=testservice.senturl((int)id);
		return list;
	}
	
} 
