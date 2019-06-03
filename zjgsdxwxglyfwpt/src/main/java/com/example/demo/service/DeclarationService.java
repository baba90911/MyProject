package com.example.demo.service;


import com.example.demo.pojo.Declaration;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.DeclarationRestful;
import com.example.demo.pojo.RESTful.List_of_items;

public interface DeclarationService {
	public boolean insertdeclaration(Declaration dec);
	
	public List_of_items findDeclarationByType(int type,PageParam pageParam);
	
	public DeclarationRestful findDeclarationByReqNum(String reqNum);
}
