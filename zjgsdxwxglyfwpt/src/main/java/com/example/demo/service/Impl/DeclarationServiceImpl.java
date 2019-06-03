package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Common_user_projDao;
import com.example.demo.dao.DeclarationDao;
import com.example.demo.dao.Department_first_projDao;
import com.example.demo.pojo.Common_user_proj;
import com.example.demo.pojo.Declaration;
import com.example.demo.pojo.Department_first_proj;
import com.example.demo.pojo.PageParam;
import com.example.demo.pojo.RESTful.CreateReqNumOrProjNum;
import com.example.demo.pojo.RESTful.DeclarationRestful;
import com.example.demo.pojo.RESTful.List_of_items;
import com.example.demo.service.DeclarationService;

@Service
public class DeclarationServiceImpl implements DeclarationService{

	@Autowired
	DeclarationDao declatationdao;
	@Autowired
	Department_first_projDao department_first_projdao;
	@Autowired
	Common_user_projDao common_user_projdao;
	@Override
	public boolean insertdeclaration(Declaration dec) {//申报项目
		CreateReqNumOrProjNum reqNum =new CreateReqNumOrProjNum();
		reqNum.setDepartment_number("0001");
		dec.setReqNum(reqNum.getReqNum());
		Department_first_proj dfp=new Department_first_proj();
		Common_user_proj cup =new Common_user_proj();
		dfp.setCompany(dec.getCompany());
		dfp.setName(dec.getName());
		dfp.setProjNum(dec.getProjNum());
		dfp.setReqNum(dec.getReqNum());
		dfp.setStatus("未审批");
		cup.setAccount("1234");
		cup.setType(dec.getType());
		cup.setName(dec.getName());
		cup.setProjNum(dec.getProjNum());
		cup.setReqNum(dec.getReqNum());
		cup.setStatus("申报中");
		declatationdao.insertDeclaration(dec);
		department_first_projdao.insertDepartment_first_proj(dfp);
		common_user_projdao.insertCommon_user_proj(cup);
		return true;
	}

	@Override
	public List_of_items findDeclarationByType(int type,PageParam pageParam) {//按照项目类别和分页获取已申报项目
		int flag=0;
	    int currPage= pageParam.getCurrPage();
	    int rowCounts = common_user_projdao.getRowCountByPage();
	    int offset = (currPage-1)*PageParam.pageSize;//起始条数
	    int size =PageParam.pageSize;
	    int all = rowCounts/size+1;
	    Map<String,Object> params=new HashMap<String, Object>();
	    params.put("offset", offset);
	    params.put("size", size);
	    params.put("type",type);
	    List<Common_user_proj> list=common_user_projdao.findCommon_user_proByType(params);
	    List_of_items loi=new List_of_items();
	    List_of_items.data data =new List_of_items().new data();
	    List<List_of_items.data.info> infoList=new ArrayList<List_of_items.data.info>();
	    for(Common_user_proj common_user_proj:list) {
	    	flag=1;
	    	List_of_items.data.info info=data.new info();
	    	info.setName(common_user_proj.getName());
	    	info.setProjNum(common_user_proj.getProjNum());
	    	info.setReqNum(common_user_proj.getReqNum());
	    	info.setStatus(common_user_proj.getStatus());
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

	
	@Override
	public DeclarationRestful findDeclarationByReqNum(String reqNum) {//按项目编号查看申报详细信息
		int flag=0;
		DeclarationRestful declarationRestful=new DeclarationRestful();
		DeclarationRestful.data data=new DeclarationRestful().new data();
		Declaration dec =declatationdao.findDeclarationByReqNum(reqNum);
		flag=1;
		data.setApproveFee(dec.getApproveFee());
		data.setCompany(dec.getCompany());
		data.setContent(dec.getContent());
		data.setDepartment(dec.getDepartment());
		data.setFeeFree(dec.getFeeFree());
		data.setFeeIntotal(dec.getFeeIntotal());
		data.setFeeRepair(dec.getFeeRepair());
		data.setLinkman(dec.getLinkman());
		data.setLocation(dec.getLocation());
		data.setName(dec.getName());
		data.setPhone(dec.getPhone());
		data.setProgress(dec.getProgress());
		data.setProjNum(dec.getProjNum());
		data.setReason(dec.getReason());
		data.setReqNum(dec.getReqNum());
		declarationRestful.setData(data);
		  if(flag==1)
	        {
			  declarationRestful.setCode(200);
			  declarationRestful.setMsg("获取消息成功");
	        }
	        else{
	        	declarationRestful.setCode(500);
	        	declarationRestful.setMsg("获取消息失败");
	        }
		return declarationRestful;
	}


}
