package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resquestServlet")
public class ResquestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResquestServlet() {
		super();
 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("user_id");
		String age = request.getParameter("user_age");

		PrintWriter out = response.getWriter();
		out.print("<table border = '1'><tr><td>이름</td><td>" + name + "</td></tr>");
		out.print("<tr><td>아이디</td><td>" + id + "</td></tr>");
		out.print("<tr><td>나이</td><td>" + age + "</td></tr>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("user_id");
		String age = request.getParameter("user_age");

		PrintWriter out = response.getWriter();
		out.print("<table border = '1'><tr><td>이름:</td><td>" + name + "</td></tr>");
		out.print("<tr><td>아이디:</td><td>" + id + "</td></tr>");
		out.print("<tr><td>나이:</td><td>" + age + "</td></tr>");
		
		
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String met = req.getMethod();
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
//		
//		System.out.println(met);
//		String name = req.getParameter("name");
//		String id = req.getParameter("user_id");
//		String age = req.getParameter("user_age");
//		
//		PrintWriter out = resp.getWriter();
//		
//		if(met.equals("GET")) {
//			out.print("<table border='1'>");
//			out.print("<tr><td>이름</td><td>");
//			out.print(name+"</td></tr><tr><td>나이</td><td>");
//			out.print(age+"</td></tr><tr><td>나이</td><td>");
//			out.print(id+"</td></tr></table>");
//		}else {
//			out.print("<ul><li>");
//			out.print(name+"</li><li>");
//			out.print(age+"</li><li>");
//			out.print(id+"</li>");
//		}
//	}

}
