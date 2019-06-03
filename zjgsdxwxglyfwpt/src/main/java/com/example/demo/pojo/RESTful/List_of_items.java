package com.example.demo.pojo.RESTful;

import java.util.List;


public class List_of_items {
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

	    public List_of_items.data getData() {
	        return data;
	    }

	    public void setData(List_of_items.data data) {
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

	        public List<List_of_items.data.info> getInfo() {
	            return info;
	        }

	        public void setInfo(List<List_of_items.data.info> info) {
	            this.info = info;
	        }

	        public class info{

	            private String projNum;

	            private String status;

	            private String name;

	            private String reqNum;
	            private String statusLeader;

	            public String getProjNum() {
	                return projNum;
	            }

	            public void setProjNum(String projNum) {
	                this.projNum = projNum;
	            }

	            public String getStatus() {
	                return status;
	            }

	            public void setStatus(String status) {
	                this.status = status;
	            }

	            public String getName() {
	                return name;
	            }

	            public void setName(String name) {
	                this.name = name;
	            }

	            public String getReqNum() {
	                return reqNum;
	            }

	            public void setReqNum(String reqNum) {
	                this.reqNum = reqNum;
	            }

				public String getStatusLeader() {
					return statusLeader;
				}

				public void setStatusLeader(String statusLeader) {
					this.statusLeader = statusLeader;
				}
	            
	        }
	    }
}
