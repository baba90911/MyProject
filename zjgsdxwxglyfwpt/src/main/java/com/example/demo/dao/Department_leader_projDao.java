package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Department_leader_proj;


public interface Department_leader_projDao {
	public void insertDepartment_leader_proj(Department_leader_proj pfp);
	public void updateDepartment_leader_proj(Map<String,Object> map);
	public List<Department_leader_proj> findDepartment_leader_projByStatus(Map<String,Object> map);
	public int getRowCountByPage();
}
