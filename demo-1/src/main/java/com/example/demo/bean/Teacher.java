package com.example.demo.bean;

public class Teacher {
	private  int Tid;
	private String  Tpassword;
	private String Tname;
	private String Tclass;
	private String Tcollege;
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTclass() {
		return Tclass;
	}
	public void setTclass(String tclass) {
		Tclass = tclass;
	}
	public String getTcollege() {
		return Tcollege;
	}
	public void setTcollege(String tcollege) {
		Tcollege = tcollege;
	}
	@Override
	public String toString() {
		return "Teacher [Tid=" + Tid + ", Tpassword=" + Tpassword + ", Tname=" + Tname + ", Tclass=" + Tclass
				+ ", Tcollege=" + Tcollege + "]";
	}
	
}
