package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Student1Service;

@RestController
public class Student1Controller {
	@Autowired
	Student1Service studnet1service;
	@PostMapping("/logoin")
	boolean login(int id,String password) throws Exception {
		boolean t=studnet1service.login(id, password);
		return t;
	}
	@PostMapping("/evaluation")
	void insert(String tname,String evaluation,int sid) {
		studnet1service.insertStundet1(tname,evaluation,sid);
	}
}
