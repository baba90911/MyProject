package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Student1;
import com.example.demo.mapper.Student1Mapper;

@Service
public class Student1Service {
	@Autowired
	Student1Mapper student1Mapper;
	public boolean login(int id,String password) throws Exception {
		boolean t = false;
		Student1 stu1=student1Mapper.findStudent1ById(id);
		if(stu1.getSpassword().equals(password)) {
			t=true;
		}
		return t;
	}
	public void insertStundet1(String Tname,String Evaluation,int Sid) {
		student1Mapper.insertStudent1(Tname, Evaluation,Sid);
	}
}
