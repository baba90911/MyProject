package com.example.demo.mapper;

import com.example.demo.bean.Teacher;

public interface TeacherMapper {
	 Teacher findTeacherById(int id) throws Exception;
	 void  insertTeacher(Teacher t)throws Exception;
	 void deleteTeacherById(int id)throws Exception;
}
