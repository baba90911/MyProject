package com.example.demo.service;

import com.example.demo.pojo.RESTful.AdviceItems;

public interface AdviceService {
	public AdviceItems findAdviceByNumAndName(String number ,String dptName);
}
