package com.example.demo.pojo;

public class Repair {
	String projNum;
	String name;
	String status; 
	String declarant; //申报者
	String receiptman;
	String reason;
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
	public String getDeclarant() {
		return declarant;
	}
	public void setDeclarant(String declarant) {
		this.declarant = declarant;
	}
	public String getReceiptman() {
		return receiptman;
	}
	public void setReceiptman(String receiptman) {
		this.receiptman = receiptman;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
