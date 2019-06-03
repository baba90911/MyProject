package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Pao_first_projDao;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.Pao_first_proj;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.service.Pao_first_projService;

@Service
public class Pao_first_projServiceImpl implements Pao_first_projService {
	@Autowired
	Pao_first_projDao pao_first_projdao;
	@Override
	public List_of_items findDeclarationByStatus(String status, PageParam pageParam) {
		 List_of_items loi=new List_of_items();
		if(status.equals("未审批")) {
			int flag=0;
		    int currPage= pageParam.getCurrPage();
		    int rowCounts = pao_first_projdao.getRowCountByPage();
		    int offset = (currPage-1)*PageParam.pageSize;//起始条数
		    int size =PageParam.pageSize;
		    int all = rowCounts/size+1;
		    Map<String,Object> params=new HashMap<String, Object>();
		    params.put("offset", offset);
		    params.put("size", size);
		    params.put("status",status);
		    List<Pao_first_proj> list=pao_first_projdao.findPao_first_projByStatus(params);
		    List_of_items.data data =new List_of_items().new data();
		    List<List_of_items.data.info> infoList=new ArrayList<List_of_items.data.info>();
		    for(Pao_first_proj pao_first_proj:list) {
		    	flag=1;
		    	List_of_items.data.info info=data.new info();
		    	info.setName(pao_first_proj.getName());
		    	info.setProjNum(pao_first_proj.getProjNum());
		    	info.setReqNum(pao_first_proj.getReqNum());
		    	info.setStatus(pao_first_proj.getStatus());
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
		    
		}
		else if(status.equals("已审批")){
			int flag=0;
		    int currPage= pageParam.getCurrPage();
		    int rowCounts = pao_first_projdao.getRowCountByPage();
		    int offset = (currPage-1)*PageParam.pageSize;//起始条数
		    int size =PageParam.pageSize;
		    int all = rowCounts/size+1;
		    Map<String,Object> params=new HashMap<String, Object>();
		    params.put("offset", offset);
		    params.put("size", size);
		    params.put("status",status);
		    List<Pao_first_proj> list=pao_first_projdao.findPao_first_projByStatus(params);
		    List_of_items.data data =new List_of_items().new data();
		    List<List_of_items.data.info> infoList=new ArrayList<List_of_items.data.info>();
		    for(Pao_first_proj pao_first_proj:list) {
		    	flag=1;
		    	List_of_items.data.info info=data.new info();
		    	info.setName(pao_first_proj.getName());
		    	info.setProjNum(pao_first_proj.getProjNum());
		    	info.setReqNum(pao_first_proj.getReqNum());
		    	info.setStatus(pao_first_proj.getStatus());
		    	info.setStatusLeader(pao_first_proj.getStatusLeader());
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
		}
		return loi;
	}
		
	

}
