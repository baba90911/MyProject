package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdviceDao;
import com.example.demo.dao.Build_projDao;
import com.example.demo.dao.Common_user_projDao;
import com.example.demo.dao.DeclarationDao;
import com.example.demo.dao.Department_first_projDao;
import com.example.demo.dao.Department_leader_projDao;
import com.example.demo.dao.Department_ref_projDao;
import com.example.demo.dao.Pao_first_projDao;
import com.example.demo.pojo.Advice;
import com.example.demo.pojo.Build_proj;
import com.example.demo.pojo.Department_leader_proj;
import com.example.demo.pojo.Department_ref_proj;
import com.example.demo.pojo.Pao_first_proj;
import com.example.demo.pojo.RESTful.ResponseMessage;
import com.example.demo.service.DepartmentAuditService;
//需要加session中的部门名字
@Service
public class DepartmentAuditServiceImpl implements DepartmentAuditService {
	@Autowired
	AdviceDao advicedao;
	@Autowired
	Department_first_projDao  department_first_projdao;
	@Autowired
	DeclarationDao declarationdao;
	@Autowired
	Common_user_projDao common_user_projdao;
	@Autowired
	Pao_first_projDao pao_first_projdao;
	@Autowired
	Department_ref_projDao department_ref_projdao;
	@Autowired
	Department_leader_projDao  department_leader_projdao;
	@Autowired
	Build_projDao build_projdao;
	@Override
	//部门审批
	public ResponseMessage firstTrial(String operation, String advice, String reqNum) {
		ResponseMessage rem =new ResponseMessage();
		if(operation.equals("同意"))
		{
			Pao_first_proj pfp =new Pao_first_proj();
			pfp.setName(common_user_projdao.findCommon_user_proNameByreqNum(reqNum));
			pfp.setReqNum(reqNum);
			pfp.setStatus("未审批");
			pao_first_projdao.insertPao_first_projDao(pfp);
			Advice advice1=new  Advice();
			Map<String,Object> params=new HashMap<String, Object>();
			Map<String,Object> params1=new HashMap<String, Object>();
			Map<String,Object> params2=new HashMap<String, Object>();
			advice1.setAdvice(advice);
			advice1.setReqNum(reqNum);
			advice1.setType(1);
			advice1.setDptName("name");
			advicedao.insertAdvice(advice1);
			params.put("projNum","12345678");
			params.put("status", "已审批");
			params.put("reqNum",reqNum);
			department_first_projdao.updateDepartment_first_projDao(params);
			params1.put("department","name");
			params1.put("reqNum",reqNum);
			declarationdao.updateData(params1);
			params2.put("status","name通过");
			params2.put("reqNum",reqNum);
			common_user_projdao.updateCommon_user_proj(params2);
			rem.setCode(200);
			rem.setMsg("操作成功");
		}
		else if(operation.equals("拒绝"))
		{
			Advice advice1=new  Advice();
			 Map<String,Object> params=new HashMap<String, Object>();
			 Map<String,Object> params1=new HashMap<String, Object>();
			 Map<String,Object> params2=new HashMap<String, Object>();
			advice1.setAdvice(advice);
			advice1.setReqNum(reqNum);
			advice1.setType(1);
			advice1.setDptName("name");
			advicedao.insertAdvice(advice1);
			params.put("status",operation);
			params.put("reqNum",reqNum);
			department_first_projdao.updateDepartment_first_projDao(params);
			params1.put("progress",operation);
			params1.put("department","name");
			params1.put("reqNum",reqNum);
			declarationdao.updateData(params1);
			params2.put("status","name拒绝");
			params2.put("reqNum",reqNum);
			common_user_projdao.updateCommon_user_proj(params2);
			rem.setCode(200);
			rem.setMsg("操作成功");
		}
		return rem;
	}
	//公管处审批未审批项目并决定是否由其他部门审批
	@Override
	public ResponseMessage PaoFirstTrial(String operation, String advice, String budget, String reqNum, ArrayList<String> list) {
		ResponseMessage rem =new ResponseMessage();
		if(operation.equals("同意")&&list!=null) {
			 Department_ref_proj drp=new  Department_ref_proj();
			 drp.setName(common_user_projdao.findCommon_user_proNameByreqNum(reqNum));
			 drp.setReqNum(reqNum);
			 drp.setStatus("未审批");
			 System.out.println(list.size());
			 for(int i=0;i<list.size();i++)
			 {
				 drp.setCompany(list.get(i));
				 System.out.println(list.get(i));
				 department_ref_projdao.insertDepartment_ref_proj(drp);
			 }
			 Advice advice1=new  Advice();
			 Map<String,Object> params=new HashMap<String, Object>();
			 Map<String,Object> params1=new HashMap<String, Object>();
			 advice1.setAdvice(advice);
			 advice1.setReqNum(reqNum);
			 advice1.setType(1);
			 advice1.setDptName("name");
			 advicedao.insertAdvice(advice1);
			 params.put("status","已审批");
			 params.put("reqNum", reqNum);
			 pao_first_projdao.updatePao_first_projDao(params);
			 params1.put("approveFee", budget);
			 params1.put("reqNum",reqNum);
			 declarationdao.updateData(params1);
			 rem.setCode(200);
			 rem.setMsg("操作成功");
		}
		else if(operation.equals("同意")&&list==null)
		{
			System.out.println("hello");
			 Advice advice1=new  Advice();
			 Map<String,Object> params=new HashMap<String, Object>();
			 Map<String,Object> params1=new HashMap<String, Object>();
			 advice1.setAdvice(advice);
			 advice1.setReqNum(reqNum);
			 advice1.setType(1);
			 advice1.setDptName("name");
			 advicedao.insertAdvice(advice1);
			 params.put("status",operation);
			 params.put("reqNum", reqNum);
			 pao_first_projdao.updatePao_first_projDao(params);
			 params1.put("approveFee", budget);
			 params1.put("reqNum",reqNum);
			 declarationdao.updateData(params1);
			 rem.setCode(200);
			 rem.setMsg("操作成功");
		}else if(operation.equals("拒绝")){
			 Advice advice1=new  Advice();
			 Map<String,Object> params=new HashMap<String, Object>();
			 Map<String,Object> params1=new HashMap<String, Object>();
			 advice1.setAdvice(advice);
			 advice1.setReqNum(reqNum);
			 advice1.setType(1);
			 advice1.setDptName("name");
			 advicedao.insertAdvice(advice1);
			 params.put("status",operation);
			 params.put("reqNum", reqNum);
			 pao_first_projdao.updatePao_first_projDao(params);
			 params1.put("progress",operation);
			 params1.put("reqNum",reqNum);
			 declarationdao.updateData(params1);
			 rem.setCode(200);
			 rem.setMsg("操作成功");
		}
		
		return rem;
		
	}
	
	//公管处发生已审批的项目至其他部门
	@Override
	public ResponseMessage PaoSendList(String reqNum, String finallocation) {
		ResponseMessage rem =new ResponseMessage();
		if(finallocation.equals("确认立项")) {
			Build_proj bp =new Build_proj();
			bp.setName(common_user_projdao.findCommon_user_proNameByreqNum(reqNum));
			bp.setReqNum(reqNum);
			bp.setStatus("未立项");
			build_projdao.insertBuild_proj(bp);
			 rem.setCode(200);
			 rem.setMsg("操作成功");
		}
		else {
			Department_leader_proj dlp=new Department_leader_proj();
			dlp.setCompany(finallocation);
			dlp.setName(common_user_projdao.findCommon_user_proNameByreqNum(reqNum));
			dlp.setReqNum(reqNum);
			dlp.setStatus("未审批");
			department_leader_projdao.insertDepartment_leader_proj(dlp);
			 rem.setCode(200);
			 rem.setMsg("操作成功");
		}
		return rem;
	}
	
	//归口部门审核
	//department_leader_projdao
	
	@Override
	public ResponseMessage refTrial(String operation, String advice, String reqNum) {
		
		ResponseMessage rem =new ResponseMessage();
		if(operation.equals("同意"))
		{
			Department_leader_proj dlp =new Department_leader_proj();
			dlp.setName(common_user_projdao.findCommon_user_proNameByreqNum(reqNum));
			dlp.setReqNum(reqNum);
			dlp.setStatus("未审批");
			department_leader_projdao.insertDepartment_leader_proj(dlp);
			Advice advice1=new  Advice();
			Map<String,Object> params=new HashMap<String, Object>();
			Map<String,Object> params2=new HashMap<String, Object>();
			advice1.setAdvice(advice);
			advice1.setReqNum(reqNum);
			advice1.setType(1);
			advice1.setDptName("name");
			advicedao.insertAdvice(advice1);
			params.put("status", "已审批");
			params.put("reqNum",reqNum);
			department_ref_projdao.updateDepartment_ref_proj(params);
			params2.put("status","name通过");
			params2.put("reqNum",reqNum);
			common_user_projdao.updateCommon_user_proj(params2);
			rem.setCode(200);
			rem.setMsg("操作成功");
		}
		else if(operation.equals("拒绝"))
		{
			Advice advice1=new  Advice();
			 Map<String,Object> params=new HashMap<String, Object>();
			 Map<String,Object> params1=new HashMap<String, Object>();
			 Map<String,Object> params2=new HashMap<String, Object>();
			advice1.setAdvice(advice);
			advice1.setReqNum(reqNum);
			advice1.setType(1);
			advice1.setDptName("name");
			advicedao.insertAdvice(advice1);
			params.put("status",operation);
			params.put("reqNum",reqNum);
			department_ref_projdao.updateDepartment_ref_proj(params);
			params1.put("progress",operation);
			params1.put("reqNum",reqNum);
			declarationdao.updateData(params1);
			params2.put("status","name拒绝");
			params2.put("reqNum",reqNum);
			common_user_projdao.updateCommon_user_proj(params2);
			rem.setCode(200);
			rem.setMsg("操作成功");
		}
		return rem;
	}
	
	
	
	

	

}
