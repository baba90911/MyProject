package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

public class Getyear {
	
	public static void  main(String [] args) {
		List<String> list = new ArrayList<String>();
		list.add("asdf");
		list.add("fxcc");
		list.add("123");
		list.add("asdfsdf1");
		String permissions=null;
		for(int i=0;i<list.size();i++)
		{
			permissions=permissions+list.get(i)+';';
		}
		System.out.println(permissions);
		String [] line =permissions.split(";");
		for(String s :line)
		{
			System.out.println(s);
		}
		
	}
}
