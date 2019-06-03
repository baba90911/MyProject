package com.example.demo.mapper;

import com.example.demo.bean.Student;

public interface StudentMapper {
	Student findStudentById(int id)throws Exception;
}
