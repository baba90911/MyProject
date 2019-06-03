package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Repair;

public interface RepairDao {
	public void insertRepair(Repair r);
	public void updateRepair(Map<String,Object> map);
	public List<Repair> findRepairByPage(Map<String,Object> map);//查的时候还要加上申报者
	public List<Repair> findRepairByPageandStatus(Map<String,Object> map);
	public int getRowCountByDeclarant(@Param("Declarant")String Declarant);
	public int getRowCountByStatus(@Param("Status")String Status);
}
