package com.example.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Repair_detail;

public interface Repair_detailDao {
	public void insertRepairDetail(Repair_detail  rd);
	public void updateRepairDetail(Map<String,Object> map);
	public Repair_detail findRepairDetailByprojNum(@Param("projNum")String projNum);
}
