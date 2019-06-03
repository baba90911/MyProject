package com.example.demo.pojo.RESTful;

import java.util.List;


public class MaintainList {
	 private int code;

	    private String msg;

	    private data data;

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

	    public MaintainList.data getData() {
	        return data;
	    }

	    public void setData(MaintainList.data data) {
	        this.data = data;
	    }

	    public class data{

	        private  int page;

	        private int all;

	        private List<info> info;

	        public int getPage() {
	            return page;
	        }

	        public void setPage(int page) {
	            this.page = page;
	        }

	        public int getAll() {
	            return all;
	        }

	        public void setAll(int all) {
	            this.all = all;
	        }

	        public List<MaintainList.data.info> getInfo() {
	            return info;
	        }

	        public void setInfo(List<MaintainList.data.info> info) {
	            this.info = info;
	        }

	        public class info{
	        	private String projNum;
	        	private String name;//项目名称
	        	private String status;
				public String getProjNum() {
					return projNum;
				}
				public void setProjNum(String projNum) {
					this.projNum = projNum;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getStatus() {
					return status;
				}
				public void setStatus(String status) {
					this.status = status;
				}
	        	
				

	            
	            
	        }
	    }
}
