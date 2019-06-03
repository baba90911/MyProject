package com.example.demo.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdviceDao;
import com.example.demo.pojo.RESTful.AdviceItems;
import com.example.demo.service.AdviceService;

@Service
public class AdviceServiceImpl implements AdviceService {

	@Autowired
	AdviceDao advicedao;
	
	@Override
	public AdviceItems findAdviceByNumAndName(String number, String dptName) {
		int flag=0;
		AdviceItems at=new AdviceItems();
		 Map<String,Object> params=new HashMap<String, Object>();
		 params.put("dptName", dptName);
		 params.put("reqNum", number);
		String advice=advicedao.findAdviceByNumAndName(params);
		if(advice.isEmpty())
		{
			params.remove("reqNum");
			params.put("dptName", number);
			advice=advicedao.findAdviceByNumAndName(params);
		}
		flag=1;
		at.setData(advice);
		if(flag==1)
		{
			at.setCode(200);
			at.setMsg("获取成功");
			
		}else {
			at.setCode(500);
			at.setMsg("获取失败");
		}
		return at;
	}

}
