package com.edu.test;

public class Main {
	public static void main(String[] args) {
		InitParamServlet ips = new InitParamServlet();
		ips.id = "user";
		
		//System.out.println(ips.showInfo());
//		System.out.println(ips.name);				//showInfo()안에서만 
		System.out.println(ips.id);
		System.out.println(ips.password);
	}
}
