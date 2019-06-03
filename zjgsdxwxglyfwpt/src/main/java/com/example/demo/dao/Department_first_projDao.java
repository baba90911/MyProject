package com.example.demo.dao;

import java.util.List;
import java.util.Map;


import com.example.demo.pojo.Department_first_proj;

public interface Department_first_projDao {
	public void insertDepartment_first_proj(Department_first_proj  dfp);
	public List<Department_first_proj> findDeclarationByStatus(Map<String,Object> map);
	public int getRowCountByPage();
	public void updateDepartment_first_projDao(Map<String,Object> map);
	
}
