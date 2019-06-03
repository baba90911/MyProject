package com.example.demo.pojo.RESTful;

import java.util.Calendar;

public class CreateReqNumOrProjNum {
	private int year;
	private String department_number;
	private static int serial_number1;
	private String serial_number;//流水号
	private String type_number;
	private static int sequence_number1;
	private String sequence_number;//序号
	private String reqNum;
	private String projNum;
	public CreateReqNumOrProjNum(){
		serial_number1=serial_number1+1;
		sequence_number1=sequence_number1+1;
		serial_number=String.valueOf(serial_number1);
		sequence_number=String.valueOf(sequence_number1);
		if(serial_number.length()<2) {
			serial_number='0'+serial_number;
		}
		if(sequence_number.length()<5)
		{
			int j =sequence_number.length();
			for(int i=0;i<5-j;i++)
			{
				sequence_number='0'+sequence_number;
			}
		}
		Calendar a=Calendar.getInstance();
		year=a.get(Calendar.YEAR);
	}
	public void setDepartment_number(String department_number) {
		this.department_number = department_number;
	}

	public void setType_number(String type_number) {
		this.type_number = type_number;
	}

	public String getReqNum() {
		reqNum=year+department_number+serial_number;
		return reqNum;
	}

	public String getProjNum() {
		projNum=type_number+year+sequence_number;
		return projNum;
	}

	
}
