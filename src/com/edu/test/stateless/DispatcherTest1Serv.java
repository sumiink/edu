package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Serv extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String param = req.getParameter("p");
		if(param == null || param.isEmpty()) {
			param = "Null";
		}
		out.print("<h3> Dispatcher 수행 1</h3>");

		ServletContext sc = this.getServletContext(); // edu 프로젝트 전체 관리객체.
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2"); // rd: dispatcher1 정보를 가져와 다음페이지로 넘겨줄 메소드제공
																		// //dispatcher2로 재지정
		req.setAttribute("data1", "Good");
		req.setAttribute("data2", param);
		rd.forward(req, resp); // 요청정보 재지정

		out.close();

	}
}
