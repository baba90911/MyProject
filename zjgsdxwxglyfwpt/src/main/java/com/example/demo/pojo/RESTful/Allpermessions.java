package com.example.demo.pojo.RESTful;

import java.util.List;

public class Allpermessions {
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
	public List<Allpermessions.data> getData() {
		return data;
	}
	public void setData(List<Allpermessions.data> data) {
		this.data = data;
	}
	public class data{
		String  permission;

		public String getPermission() {
			return permission;
		}

		public void setPermission(String permission) {
			this.permission = permission;
		}
		
	}
	
}
