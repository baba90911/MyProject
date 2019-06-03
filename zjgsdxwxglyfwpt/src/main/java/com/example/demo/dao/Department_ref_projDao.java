package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Department_ref_proj;

public interface Department_ref_projDao {
	public void insertDepartment_ref_proj(Department_ref_proj pfp);
	public void updateDepartment_ref_proj(Map<String,Object> map);
	public List<Department_ref_proj> findPDepartment_ref_projByStatus(Map<String,Object> map);
	public int getRowCountByPage();
}
