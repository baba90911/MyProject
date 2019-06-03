package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Teacher;
import com.example.demo.mapper.TeacherMapper;

@Service
public class ManageService {
	@Autowired
	TeacherMapper teacherMapper;
	public void deleteteacher(int Tid) throws Exception {
		teacherMapper.deleteTeacherById(Tid);
	}
	public void insertteacher(Teacher t) throws Exception {
		teacherMapper.insertTeacher(t);
	}
	
}
