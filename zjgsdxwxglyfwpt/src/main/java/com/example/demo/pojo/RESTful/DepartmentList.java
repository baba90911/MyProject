package com.example.demo.pojo.RESTful;

import java.util.List;

public class DepartmentList {
	 private int code;
	 private String msg;
	 private List<data> data;
	  public int getCode() {
	        return code;
	    }

	    public void setCode(int code) {
	        this.code = code;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

		public List<DepartmentList.data> getData() {
			return data;
		}

		public void setData(List<DepartmentList.data> data) {
			this.data = data;
		}
	    public class data{
	    	private String department;

			public String getDepartment() {
				return department;
			}

			public void setDepartment(String department) {
				this.department = department;
			}
	    	
	    }
}
