package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Pao_first_proj;

public interface Pao_first_projDao {
	public void insertPao_first_projDao(Pao_first_proj pfp);
	public void updatePao_first_projDao(Map<String,Object> map);
	public List<Pao_first_proj> findPao_first_projByStatus(Map<String,Object> map);
	public int getRowCountByPage();
}
