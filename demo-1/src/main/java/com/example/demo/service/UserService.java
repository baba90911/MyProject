package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Manage;
import com.example.demo.bean.Student;
import com.example.demo.bean.Teacher;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
@Service
public class UserService {
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	ManageMapper manageMapper;
	@Autowired
	StudentMapper studentMapper;
	public Object login(int id,String password,int type) throws Exception {
		Object i = null;
		if(type==2)
		{
			Student s=studentMapper.findStudentById(id);
			if(s!=null) {
				if(s.getSpassword().equals(password))
				{
					i= s;
				}
				else i=null;
			}
			else i= null;
		}
		else if(type==0)
		{
			Teacher t=teacherMapper.findTeacherById(id);
			if(t!=null)
			{
				if(t.getTpassword().equals(password))
				{
					i= t;
				}
				else i=null;
			}
			else i=null;	
		}
		else if(type==1)
		{
			Manage m=manageMapper.findManageById(id);
			if(m!=null)
			{
				if(m.getMpassword().equals(password))
				{
					i= m;
				}
				else i=null;
			}
			else i=null;
		}
		return i;
	}
	public Teacher findTeacherByid(int id) throws Exception {
		Teacher t=teacherMapper.findTeacherById(id);
		if(t==null) {
			return null;
		}else return t;
	}
	
}
