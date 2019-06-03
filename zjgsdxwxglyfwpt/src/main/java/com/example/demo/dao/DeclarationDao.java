package com.example.demo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Declaration;

public interface DeclarationDao {
	public void insertDeclaration(Declaration dec);
	public int getRowCountByPage();
	public List<Declaration> findDeclarationBySP(Map<String,Object> map);
	public  Declaration findDeclarationByReqNum(@Param("rqnum")String reqNum);
	public void updateData(Map<String,Object> map); 
}
