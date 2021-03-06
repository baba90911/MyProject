package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeclarationDao;
import com.example.demo.dao.Department_first_projDao;
import com.example.demo.pojo.Department_first_proj;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.service.Department_fist_projService;

@Service
public class Department_first_projServiceImpl implements Department_fist_projService {

	@Autowired
	Department_first_projDao department_first_projdao;
	@Autowired
	DeclarationDao declarationdao;
	@Override
	
	public List_of_items findDeclarationByStatus(String status, PageParam pageParam) {
		int flag=0;
	    int currPage= pageParam.getCurrPage();
	    int rowCounts = department_first_projdao.getRowCountByPage();
	    int offset = (currPage-1)*PageParam.pageSize;//起始条数
	    int size =PageParam.pageSize;
	    int all = rowCounts/size+1;
	    Map<String,Object> params=new HashMap<String, Object>();
	    params.put("offset", offset);
	    params.put("size", size);
	    params.put("status",status);
	    List<Department_first_proj> list=department_first_projdao.findDeclarationByStatus(params);
	    List_of_items loi=new List_of_items();
	    List_of_items.data data =new List_of_items().new data();
	    List<List_of_items.data.info> infoList=new ArrayList<List_of_items.data.info>();
	    for(Department_first_proj department_first_proj:list) {
	    	flag=1;
	    	List_of_items.data.info info=data.new info();
	    	info.setName(department_first_proj.getName());
	    	info.setProjNum(department_first_proj.getProjNum());
	    	info.setReqNum(department_first_proj.getReqNum());
	    	info.setStatus(department_first_proj.getStatus());
	    	infoList.add(info);
	    }
	    data.setInfo(infoList);
	    data.setAll(all);
	    data.setPage(currPage);
	    loi.setData(data);
	    if(flag==1)
        {
	    	loi.setCode(200);
	    	loi.setMsg("获取消息成功");
        }
        else{
        	loi.setCode(500);
        	loi.setMsg("获取消息失败");
        }
	    return loi;
	}
	
	

}
