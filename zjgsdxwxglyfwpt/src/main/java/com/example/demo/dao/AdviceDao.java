package com.example.demo.dao;

import java.util.Map;

import com.example.demo.pojo.Advice;

public interface AdviceDao {
	public void insertAdvice(Advice advice);
	public String findAdviceByNumAndName(Map<String,Object> map);
}
