package com.example.demo.dao;

import java.util.List;
import java.util.Map;


import com.example.demo.pojo.Common_user_proj;

public interface Common_user_projDao {
	public void insertCommon_user_proj(Common_user_proj cup);
	public int getRowCountByPage();
	public void updateCommon_user_proj(Map<String,Object> map);
	public List<Common_user_proj> findCommon_user_proByStatus(String status);
	public List<Common_user_proj> findCommon_user_proByType(Map<String,Object> map);
	public String findCommon_user_proNameByreqNum(String reqNum);
}
