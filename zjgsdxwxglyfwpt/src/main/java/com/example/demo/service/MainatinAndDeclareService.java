package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.AcceptList;
import com.example.demo.pojo.RESTful.AcceptTable;
import com.example.demo.pojo.RESTful.DeclareTable;
import com.example.demo.pojo.RESTful.MaintainList;
import com.example.demo.pojo.RESTful.ResponseMessage;

public interface MainatinAndDeclareService {
	public ResponseMessage maintenanceReport(String projNum,String name,String department ,String linkman,String phone,String content,MultipartFile  attach,String location);
	public DeclareTable findMaintainDetailByprojNum(String number_req);
	public MaintainList findMaintainListByPage(PageParam pageParam);
	public AcceptList findAcceptListByPageAndStatus(String status,PageParam pageParam);
	public ResponseMessage acceptTable(String name,String date,String content,String material,String amount,String operation ,String projNum);
	public ResponseMessage refuseTable(String operation,String projNum,String reason);
	public AcceptTable  printAcceptTable(String projNum);
}
