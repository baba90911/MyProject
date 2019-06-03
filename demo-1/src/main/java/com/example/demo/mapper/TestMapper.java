package com.example.demo.mapper;

import java.util.List;

import com.example.demo.bean.Test;

public interface TestMapper {
	List<Test> findTestByTid(int id) throws Exception;
	void  insertTest(Test t)throws Exception;
}
