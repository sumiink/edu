package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")

public class FirstServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inint()");
		 
	}
	
//	@Override //서블릿이 가진 방식
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service()");
//		res.getWriter().print("<h1>Hello</h1>");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
}
