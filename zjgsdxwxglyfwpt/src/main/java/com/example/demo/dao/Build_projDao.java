package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Build_proj;

public interface Build_projDao {
	public void insertBuild_proj(Build_proj pfp);
	public void updateBuild_proj(Map<String,Object> map);
	public List<Build_proj> findBuild_projByStatus(Map<String,Object> map);
	public int getRowCountByPage();
}