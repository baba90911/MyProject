package com.example.demo.service;


import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.Proj_record_List_of_items;

public interface Proj_recordService {
	public Proj_record_List_of_items findProj_recordByPage(PageParam pageParam);
	public Proj_record_List_of_items findProj_recordDaoByPageAndNumber(PageParam pageParam,String number);
	public Proj_record_List_of_items updateProj_record(String number_record,String number_record_hall,String number,PageParam pageParam);
}
