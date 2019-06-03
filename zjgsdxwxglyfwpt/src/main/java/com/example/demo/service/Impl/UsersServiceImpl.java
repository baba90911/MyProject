package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDao;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.Users;
import com.example.demo.pojo.RESTful.Allpermessions;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.pojo.RESTful.UsersPermisssionsItems;
import com.example.demo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDao usersdao;

	@Override
	public ResponseMessage deleteuserByusername(String username) {
		ResponseMessage rsm =new ResponseMessage();
		int flag=0;
		usersdao.deleteuserByusername(username);
		flag=1;
		if(flag==1) {
			rsm.setCode(200);
			rsm.setMsg("删除成功");
		}
		else {
			rsm.setCode(500);
			rsm.setMsg("删除失败");
		}
		return rsm;
	}

	@Override
	public ResponseMessage initializingPwd(String username) {
		ResponseMessage rsm =new ResponseMessage();
		int flag=0;
		usersdao.initializingPwd(username);
		flag=1;
		if(flag==1) {
			rsm.setCode(200);
			rsm.setMsg("初始化成功");
		}
		else {
			rsm.setCode(500);
			rsm.setMsg("初始化失败");
		}
		return rsm;
	}

	@Override
	public ResponseMessage updatePermissions(String username, ArrayList<String> list) {
		ResponseMessage rsm =new ResponseMessage();
		int flag=0;
		String permissions=null;
		for(int i=0;i<list.size();i++)
		{
			if(permissions==null)
				permissions=list.get(i)+';';
			else
				permissions=permissions+list.get(i)+';';
		}
		 Map<String,Object> params=new HashMap<String, Object>();
		 params.put("account", username);
		 params.put("permissions", permissions);
		usersdao.updatePermissions(params);
		flag=1;
		if(flag==1) {
			rsm.setCode(200);
			rsm.setMsg("修改权限成功");
		}
		else {
			rsm.setCode(500);
			rsm.setMsg("修改权限失败");
		}
		return rsm;
	}

	@Override
	public UsersPermisssionsItems findUsersByPage(PageParam pageParam) {
		int flag=0;
		int currPage= pageParam.getCurrPage();
		int rowCounts=usersdao.getRowCountByPage();
		int offset=(currPage-1)*PageParam.pageSize;
		int size =PageParam.pageSize;
		int all = 0;
		if(rowCounts%size==0)
		   all=rowCounts/size;
		else
		    all=rowCounts/size+1;
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("size", size);
		List<Users> list=usersdao.findUsersByPage(params);
		flag=1;
		UsersPermisssionsItems upi =new UsersPermisssionsItems();
		UsersPermisssionsItems.data data=new UsersPermisssionsItems().new data();
		List<UsersPermisssionsItems.data.info>  infoList=new ArrayList<UsersPermisssionsItems.data.info>();
		for(Users users:list) {
			UsersPermisssionsItems.data.info info=data.new info();
			info.setUsername(users.getAccount());
			String [] line =users.getPermissions().split(";");
			List<UsersPermisssionsItems.data.info.list>  permisssionlist=new ArrayList<UsersPermisssionsItems.data.info.list>();
			for(int i=0;i<line.length;i++)
			{
				UsersPermisssionsItems.data.info.list list1=info.new list();
				list1.setPsermission(line[i]);
				permisssionlist.add(list1);
			}
			info.setList(permisssionlist);
			infoList.add(info);
		}
		  data.setInfo(infoList);
		  data.setAll(all);
		  data.setPage(currPage);
		  upi.setData(data);
		  if(flag==1)
	        {
			  upi.setCode(200);
			  upi.setMsg("获取消息成功");
	        }
	        else{
	        	upi.setCode(500);
	        	upi.setMsg("获取消息失败");
	        }
		return upi;
	}

	@Override
	public Allpermessions findAllPermission() {
		int flag=0;
		Allpermessions  allp =new Allpermessions();
		List<Allpermessions.data> datalist = new ArrayList<Allpermessions.data>();
		String permissions =usersdao.findAllPermission();
		String [] line =permissions.split(";");
		for(String permission:line) {
			Allpermessions.data data =new Allpermessions().new data();
			data.setPermission(permission);
			datalist.add(data);
		}
		flag=1;
		allp.setData(datalist);
		 if(flag==1)
	        {
			 allp.setCode(200);
			 allp.setMsg("获取消息成功");
	        }
	        else{
	        	allp.setCode(500);
	        	allp.setMsg("获取消息失败");
	        }
			return allp;
	}

}
