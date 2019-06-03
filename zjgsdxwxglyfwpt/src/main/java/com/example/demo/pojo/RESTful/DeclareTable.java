package com.example.demo.pojo.RESTful;

public class DeclareTable {
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
	public DeclareTable.data getData() {
		return data;
	}
	public void setData(DeclareTable.data data) {
		this.data = data;
	}
	public class data{
		private String name; //项目名称
		private String department;
		private String linkman;
		private String phone;
		private String content; 
		private String attach; //文件file
		private String lication;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getLinkman() {
			return linkman;
		}
		public void setLinkman(String linkman) {
			this.linkman = linkman;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAttach() {
			return attach;
		}
		public void setAttach(String attach) {
			this.attach = attach;
		}
		public String getLication() {
			return lication;
		}
		public void setLication(String lication) {
			this.lication = lication;
		}
		
		
		
	}
}
