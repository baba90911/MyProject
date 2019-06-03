package com.example.demo.mapper;

import com.example.demo.bean.Student1;

public interface Student1Mapper {
	Student1 findStudent1ById(int id)throws Exception;
	void insertStudent1(String Tname,String Evaluation,int Sid);
}
