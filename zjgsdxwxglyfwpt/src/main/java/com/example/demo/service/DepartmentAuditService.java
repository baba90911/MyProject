package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.pojo.RESTful.ResponseMessage;

public interface DepartmentAuditService {
	public ResponseMessage firstTrial(String operation,String advice,String reqNum);
	public ResponseMessage PaoFirstTrial(String operation,String advice,String budget, String reqNum,ArrayList<String> list);
	public ResponseMessage PaoSendList(String reqNum,String finallocation);
	public ResponseMessage refTrial(String operation,String advice,String reqNum);
}
