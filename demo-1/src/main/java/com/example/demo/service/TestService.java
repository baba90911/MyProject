package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Picture;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.Test;
import com.example.demo.mapper.PictureMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.mapper.TestMapper;

@Service 
public class TestService {
	@Autowired
	PictureMapper pictureMapper;
	@Autowired
	TestMapper testMapper;
	@Autowired
	TeacherMapper teacherMapper;
	public int count(List<Test> t) throws Exception {
		int score=0;
		for(int i=0;i<t.size();i++)
		{
			Picture p=pictureMapper.findPictureByPaddress(t.get(i).getPaddress());
			if(p==null) {
				score=0;
			}else {
				if(p.getSname().equals(t.get(i).getSname()))
				{
					score=score+5;
				}
				else
				{
					if(p.getSclass().equals(t.get(i).getSclass()))
					{
						score=score+2;
					}
				}
			}
		
		}
		return score;		
	}

	public List<String> senturl(int id) throws Exception{
		
		Teacher t=teacherMapper.findTeacherById(id);
		List<Picture> p=pictureMapper.findPictureByTname(t.getTname());
		List<String> url=new ArrayList<String>();
		for(int i=0;i<p.size();i++)
		{
			
			String str=p.get(i).getPaddress();
			url.add(str);
			
		}
		return url;
	}
}
