package com.example.demo.pojo.RESTful;

import java.util.List;
//新增

public class UsersPermisssionsItems {
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

	    public UsersPermisssionsItems.data getData() {
	        return data;
	    }

	    public void setData(UsersPermisssionsItems.data data) {
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

	        public List<UsersPermisssionsItems.data.info> getInfo() {
	            return info;
	        }

	        public void setInfo(List<UsersPermisssionsItems.data.info> info) {
	            this.info = info;
	        }

	        public class info{

	            private String username;
	            private List<list> list;
				public String getUsername() {
					return username;
				}
				public void setUsername(String username) {
					this.username = username;
				}
				public List<UsersPermisssionsItems.data.info.list> getList() {
					return list;
				}
				public void setList(List<UsersPermisssionsItems.data.info.list> list) {
					this.list = list;
				}
				public class list{
					String psermission;

					public String getPsermission() {
						return psermission;
					}

					public void setPsermission(String psermission) {
						this.psermission = psermission;
					}
					
				}
	            
	        }
	    }
}
