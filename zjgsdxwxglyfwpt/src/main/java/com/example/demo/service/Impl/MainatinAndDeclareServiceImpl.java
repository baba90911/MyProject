package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.RepairDao;
import com.example.demo.dao.Repair_detailDao;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.Repair;
import com.example.demo.pojo.Repair_detail;
import com.example.demo.pojo.RESTful.AcceptList;
import com.example.demo.pojo.RESTful.AcceptTable;
import com.example.demo.pojo.RESTful.ConstantString;
import com.example.demo.pojo.RESTful.DeclareTable;
import com.example.demo.pojo.RESTful.MaintainList;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.service.MainatinAndDeclareService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
@Service
public class MainatinAndDeclareServiceImpl implements MainatinAndDeclareService {

	@Autowired
	Repair_detailDao repair_detaildao;
	@Autowired
	RepairDao repairdao;
	
	@Override
	public ResponseMessage maintenanceReport(String projNum,String name, String department, String linkman, String phone,
			String content, MultipartFile  attach, String location) {
		ResponseMessage rm =new ResponseMessage();
		String declarant="123456";
		Repair_detail rd=new Repair_detail();
		Repair r=new Repair();
		r.setDeclarant(declarant);
		r.setName(name);
		r.setProjNum(projNum);
		r.setStatus("未接单");
		repairdao.insertRepair(r);
		rd.setDeclarant(declarant);
		rd.setProjNum(projNum);
		rd.setName(name);
		rd.setCompany(department);
		rd.setLinkman(linkman);
		rd.setPhone(phone);
		rd.setContent(content);
		rd.setLocation(location);
		if (!attach.isEmpty()) {
            if (attach.getSize() / 1024 > ConstantString.MAX_IMAGE_SIZE) {
                rm.setCode(300);
                rm.setMsg("文件过大（文件大小不得大于10M）");
                return rm;
            }
            String orinFileName = attach.getOriginalFilename();
            int pos = orinFileName.lastIndexOf(".");
            String extName = orinFileName.substring(pos);
            String fileName = projNum + extName;
            String path = ConstantString.PIC_FINANCE_FILE_PATH + fileName;
            rd.setFile(path);
            repair_detaildao.insertRepairDetail(rd);
            try {
                FileUtils.copyInputStreamToFile(attach.getInputStream(), new File(ConstantString.PIC_FINANCE_FILE_PATH,
                        fileName));
                rm.setCode(200);
                rm.setMsg("更新数据库成功，上传成功。");
            } catch (IOException e) {
                e.printStackTrace();
                rm.setCode(250);
                rm.setMsg("更新数据库成功，上传失败。");
            }
        }
		return rm;
	}

	@Override
	public DeclareTable findMaintainDetailByprojNum(String number_req) {
		int flag=0;
		DeclareTable dt=new DeclareTable();
		DeclareTable.data data=new DeclareTable().new data();
		Repair_detail rd=repair_detaildao.findRepairDetailByprojNum(number_req);
		data.setName(rd.getName());
		data.setDepartment(rd.getCompany());
		data.setLinkman(rd.getLinkman());
		data.setPhone(rd.getPhone());
		data.setContent(rd.getContent());
		data.setAttach(rd.getFile());
		data.setLication(rd.getLocation());
		dt.setData(data);
		flag=1;
		if(flag==1)
		{
			dt.setCode(200);
			dt.setMsg("获取成功");
		}else {
			dt.setCode(500);
			dt.setMsg("获取失败");
		}
		return dt;
	}

	@Override
	public MaintainList findMaintainListByPage(PageParam pageParam) {
		MaintainList mlist=new MaintainList();
		String Declarant="123456";
		int flag=0;
		int currPage= pageParam.getCurrPage();
		int rowCounts =repairdao.getRowCountByDeclarant(Declarant);
		int offset = (currPage-1)*PageParam.pageSize;//起始条数
		int size =PageParam.pageSize;
		 int all = 0;
		    if(rowCounts%size==0)
		    	all=rowCounts/size;
		    else
		    	all=rowCounts/size+1;
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("declarant", Declarant);
		params.put("offset", offset);
		params.put("size", size);
		List<Repair> re =repairdao.findRepairByPage(params);
		MaintainList.data data=new MaintainList().new data();
		List<MaintainList.data.info> infoList=new ArrayList<MaintainList.data.info>();
		for(Repair repair:re) {
			MaintainList.data.info info= data.new info();
			info.setName(repair.getName());
			info.setProjNum(repair.getProjNum());
			info.setStatus(repair.getStatus());
			infoList.add(info);
		}
		data.setInfo(infoList);
		data.setAll(all);
		data.setPage(currPage);
		mlist.setData(data);
		flag=1;
	    if(flag==1)
        {
	    	mlist.setCode(200);
	    	mlist.setMsg("获取消息成功");
        }
        else{
        	mlist.setCode(500);
        	mlist.setMsg("获取消息失败");
        }
		return mlist;
	}

	@Override
	public AcceptList findAcceptListByPageAndStatus(String status, PageParam pageParam) {
		AcceptList al=new  AcceptList();
		int flag=0;
		AcceptList.data data=new AcceptList().new data();
		List<AcceptList.data.info> infolist=new ArrayList<AcceptList.data.info>();
		String receiptman="11231";
		if(status.equals("未接单")) {
			int currPage= pageParam.getCurrPage();
			int rowCounts =repairdao.getRowCountByStatus(status);
			int offset = (currPage-1)*PageParam.pageSize;//起始条数
			int size =PageParam.pageSize;
			int all = 0;
			   if(rowCounts%size==0)
				   all=rowCounts/size;
			   else
				   all=rowCounts/size+1;
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("status",status);
			params.put("offset", offset);
			params.put("size", size);
			List<Repair> list=repairdao.findRepairByPageandStatus(params);
			for(Repair repair: list) {
				AcceptList.data.info info=data.new info();
				info.setName(repair.getName());
				info.setProjNum(repair.getProjNum());
				infolist.add(info);
			}
			data.setInfo(infolist);
			data.setAll(all);
			data.setPage(currPage);
			al.setData(data);
			flag=1;
		    if(flag==1)
	        {
		    	al.setCode(200);
		    	al.setMsg("获取消息成功");
	        }
	        else{
	        	al.setCode(500);
	        	al.setMsg("获取消息失败");
	        }
		}else if(status.equals("已接单")) {
			int currPage= pageParam.getCurrPage();
			int rowCounts =repairdao.getRowCountByStatus(status);
			int offset = (currPage-1)*PageParam.pageSize;//起始条数
			int size =PageParam.pageSize;
			int all = 0;
			   if(rowCounts%size==0)
				   all=rowCounts/size;
			   else
				   all=rowCounts/size+1;
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("status",status);
			params.put("offset", offset);
			params.put("size", size);
			params.put("receiptman", receiptman);
			List<Repair> list=repairdao.findRepairByPageandStatus(params);
			for(Repair repair: list) {
				AcceptList.data.info info=data.new info();
				info.setName(repair.getName());
				info.setProjNum(repair.getProjNum());
				infolist.add(info);
			}
			data.setInfo(infolist);
			data.setAll(all);
			data.setPage(currPage);
			al.setData(data);
			flag=1;
		    if(flag==1)
	        {
		    	al.setCode(200);
		    	al.setMsg("获取消息成功");
	        }
	        else{
	        	al.setCode(500);
	        	al.setMsg("获取消息失败");
	        }
		}
		return al;
	}

	@Override
	public ResponseMessage acceptTable(String name, String date, String content, String material, String amount,
			String operation, String projNum) {
		ResponseMessage rm =new ResponseMessage();
		int flag=0;
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("status","已接单");
		params.put("receiptman", name);
		params.put("projNum", projNum);
		repairdao.updateRepair(params);
		Map<String,Object> params1=new HashMap<String, Object>();
		params1.put("receiptman", name);
		params1.put("date", date);
		params1.put("repairContent", content);
		params1.put("material", material);
		params1.put("money", amount);
		params1.put("projNum", projNum);
		repair_detaildao.updateRepairDetail(params1);
		flag=1;
		if(flag==1)
		{
			rm.setCode(200);
			rm.setMsg("接单成功");
		}else {
			rm.setCode(500);
			rm.setMsg("接单失败");
		}
		return rm;
	}

	@Override
	public ResponseMessage refuseTable(String operation, String projNum, String reason) {
		ResponseMessage rm =new ResponseMessage();
		int flag=0;
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("status", operation);
		params.put("reason", reason);
		params.put("projNum", projNum);
		repairdao.updateRepair(params);
		flag=1;
		if(flag==1)
		{
			rm.setCode(200);
			rm.setMsg("退单成功");
		
		}else {
			rm.setCode(500);
			rm.setMsg("退单失败");
		}
		return rm;
	}

	@Override
	public AcceptTable printAcceptTable(String projNum) {
		AcceptTable at=new AcceptTable();
		Repair_detail rd=repair_detaildao.findRepairDetailByprojNum(projNum);
		at.setName(rd.getReceiptman());
		at.setDate(rd.getDate());
		at.setContent(rd.getRepairContent());
		at.setMaterial(rd.getMaterial());
		at.setAmount(rd.getMoney());
		return at;
	}

}
