package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Department_messageDao;
import com.example.demo.pojo.Department_message;
import com.example.demo.pojo.RESTful.DepartmentList;
import com.example.demo.service.Department_messageService;

@Service
public class Department_messageServiceImpl implements Department_messageService {
	@Autowired
	Department_messageDao departmentdao;
	@Override
	public DepartmentList findAllDepartment() {
		int flag=0;
		DepartmentList dml =new DepartmentList();
		List<DepartmentList.data> datalist=new ArrayList<DepartmentList.data>();
		List<Department_message> dtm=departmentdao.findAllDepartment();
		for(Department_message department_message:dtm) {
			DepartmentList.data data=new DepartmentList().new data();
			data.setDepartment(department_message.getDepName());
			datalist.add(data);
		}
		dml.setData(datalist);
		flag=1;
		 if(flag==1)
	        {
			 dml.setCode(200);
			 dml.setMsg("获取成功");
	        }
	        else{
	        	dml.setCode(500);
	        	dml.setMsg("获取失败");
	        }
		return dml;
	}

}
