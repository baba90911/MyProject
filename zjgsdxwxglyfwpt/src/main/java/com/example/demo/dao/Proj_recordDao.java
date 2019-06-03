package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Proj_record;

public interface Proj_recordDao {
	public void insertProj_record(Proj_record pr);
	public int getRowCountByPage();
	public List<Proj_record> findProj_recordByPage(Map<String,Object> map);
	public List<Proj_record> findProj_recordDaoByPageAndNumber(Map<String,Object> map);
	public void updateProj_record(Map<String,Object> map);
}
