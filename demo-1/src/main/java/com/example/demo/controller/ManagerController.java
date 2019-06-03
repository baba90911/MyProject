package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Teacher;
import com.example.demo.service.ManageService;
import com.example.demo.service.UserService;

@RequestMapping("/test")
@RestController
public class ManagerController {
	@Autowired
	ManageService managerservice;
	@Autowired
	UserService userService;
	@GetMapping("/manager_teacher")
	public void deleteacher(int i) {
		try {
			managerservice.deleteteacher(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("/manager_findteacher")
	public Teacher findTeacherById(int id) throws Exception{
		Teacher t=userService.findTeacherByid(id);
		return t;
	}
	@PostMapping(value="/manager_addteacher",consumes = "application/json")
	public void addteacher(@RequestBody Teacher t) {
		try {
			managerservice.insertteacher(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

