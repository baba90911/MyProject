package com.example.demo.service;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.List_of_items;

public interface Pao_first_projService {
	public List_of_items findDeclarationByStatus(String status,PageParam pageParam);
}
