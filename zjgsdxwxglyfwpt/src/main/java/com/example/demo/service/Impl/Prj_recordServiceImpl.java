package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Proj_recordDao;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.Proj_record;
import com.example.demo.pojo.RESTful.Proj_record_List_of_items;
import com.example.demo.service.Proj_recordService;

@Service
public class Prj_recordServiceImpl implements Proj_recordService {

	@Autowired
	Proj_recordDao proj_recorddao;
	@Override
	public Proj_record_List_of_items findProj_recordByPage(PageParam pageParam) {
		int flag=0;
	    int currPage= pageParam.getCurrPage();
	    int rowCounts = proj_recorddao.getRowCountByPage();
	    int offset = (currPage-1)*PageParam.pageSize;//起始条数
	    int size =PageParam.pageSize;
	    int all = 0;
	    if(rowCounts%size==0)
	    	all=rowCounts/size;
	    else
	    	all=rowCounts/size+1;
	    Map<String,Object> params=new HashMap<String, Object>();
	    params.put("offset", offset);
	    params.put("size", size);
	    List<Proj_record> list=proj_recorddao.findProj_recordByPage(params);
	    Proj_record_List_of_items prloi=new Proj_record_List_of_items();
	    Proj_record_List_of_items.data data =new Proj_record_List_of_items().new data();
	    List<Proj_record_List_of_items.data.info> infoList=new ArrayList<Proj_record_List_of_items.data.info>();
	    for(Proj_record proj_record:list) {
	    	flag=1;
	    	 Proj_record_List_of_items.data.info info=data.new info();
	    	info.setName(proj_record.getName());
	    	info.setProjNum(proj_record.getProjNum());
	    	info.setReqNum(proj_record.getReqNum());
	    	info.setStatus(proj_record.getStatus());
	    	info.setNumberRecord(proj_record.getNumberRecord());
	    	info.setNumberRecordHall(proj_record.getNumberRecordHall());
	    	infoList.add(info);
	    }
	    data.setInfo(infoList);
	    data.setAll(all);
	    data.setPage(currPage);
	    prloi.setData(data);
	    if(flag==1)
        {
	    	prloi.setCode(200);
	    	prloi.setMsg("获取消息成功");
        }
        else{
        	prloi.setCode(500);
        	prloi.setMsg("获取消息失败");
        }
	    return prloi;
	}

	@Override
	public Proj_record_List_of_items findProj_recordDaoByPageAndNumber(PageParam pageParam, String number) {
		int flag=0;
	    int currPage= pageParam.getCurrPage();
	    int rowCounts = proj_recorddao.getRowCountByPage();
	    int offset = (currPage-1)*PageParam.pageSize;//起始条数
	    int size =PageParam.pageSize;
	    int all = 0;
	    if(rowCounts%size==0)
	    	all=rowCounts/size;
	    else
	    	all=rowCounts/size+1;
	    Map<String,Object> params=new HashMap<String, Object>();
	    params.put("offset", offset);
	    params.put("size", size);
	    params.put("numberRecord",number);
	    List<Proj_record> list=proj_recorddao.findProj_recordDaoByPageAndNumber(params);
	    if(list.size()==0) {
	    	 params.remove("numberRecord");
	    	 params.put("numberRecordHall",number);
	    	 list=proj_recorddao.findProj_recordDaoByPageAndNumber(params);
	    }
	    Proj_record_List_of_items prloi=new Proj_record_List_of_items();
	    Proj_record_List_of_items.data data =new Proj_record_List_of_items().new data();
	    List<Proj_record_List_of_items.data.info> infoList=new ArrayList<Proj_record_List_of_items.data.info>();
	    for(Proj_record proj_record:list) {
	    	flag=1;
	    	 Proj_record_List_of_items.data.info info=data.new info();
	    	info.setName(proj_record.getName());
	    	info.setProjNum(proj_record.getProjNum());
	    	info.setReqNum(proj_record.getReqNum());
	    	info.setStatus(proj_record.getStatus());
	    	info.setNumberRecord(proj_record.getNumberRecord());
	    	info.setNumberRecordHall(proj_record.getNumberRecordHall());
	    	infoList.add(info);
	    }
	    data.setInfo(infoList);
	    data.setAll(all);
	    data.setPage(currPage);
	    prloi.setData(data);
	    if(flag==1)
        {
	    	prloi.setCode(200);
	    	prloi.setMsg("获取消息成功");
        }
        else{
        	prloi.setCode(500);
        	prloi.setMsg("获取消息失败");
        }
	    return prloi;
	}

	@Override
	public Proj_record_List_of_items updateProj_record(String number_record, String number_record_hall, String number,PageParam pageParam) {
		 Map<String,Object> params=new HashMap<String, Object>();
		 params.put("numberRecord", number_record);
		 params.put("numberRecordHall", number_record_hall);
		 params.put("projNum", number);
		 proj_recorddao.updateProj_record(params);
		 int flag=0;
		    int currPage= pageParam.getCurrPage();
		    int rowCounts = proj_recorddao.getRowCountByPage();
		    int offset = (currPage-1)*PageParam.pageSize;//起始条数
		    int size =PageParam.pageSize;
		    int all = 0;
		    if(rowCounts%size==0)
		    	all=rowCounts/size;
		    else
		    	all=rowCounts/size+1;
		    Map<String,Object> params1=new HashMap<String, Object>();
		    params1.put("offset", offset);
		    params1.put("size", size);
		    List<Proj_record> list=proj_recorddao.findProj_recordByPage(params1);
		    Proj_record_List_of_items prloi=new Proj_record_List_of_items();
		    Proj_record_List_of_items.data data =new Proj_record_List_of_items().new data();
		    List<Proj_record_List_of_items.data.info> infoList=new ArrayList<Proj_record_List_of_items.data.info>();
		    for(Proj_record proj_record:list) {
		    	flag=1;
		    	 Proj_record_List_of_items.data.info info=data.new info();
		    	info.setName(proj_record.getName());
		    	info.setProjNum(proj_record.getProjNum());
		    	info.setReqNum(proj_record.getReqNum());
		    	info.setStatus(proj_record.getStatus());
		    	info.setNumberRecord(proj_record.getNumberRecord());
		    	info.setNumberRecordHall(proj_record.getNumberRecordHall());
		    	infoList.add(info);
		    }
		    data.setInfo(infoList);
		    data.setAll(all);
		    data.setPage(currPage);
		    prloi.setData(data);
		    if(flag==1)
	        {
		    	prloi.setCode(200);
		    	prloi.setMsg("获取消息成功");
	        }
	        else{
	        	prloi.setCode(500);
	        	prloi.setMsg("获取消息失败");
	        }
		    return prloi;

	}

}
