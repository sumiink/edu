package com.edu.test;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	int number = 0; 		//doGet안에서는 독립적으로 각각 실행되고 local변수(현재위치)에서 선언된상태에서는 공유되어 실행됨.
	
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		String str = req.getParameter("msg");

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Thread Test</title></head>");
		out.print("<body><h2> 처리결과(지역변수)</h2>");
		while(number++ <10) {
			out.print(str + " : " + number + "<br>");			//webbrowser
			out.flush();
			System.out.println(str + " : " + number);  //console
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>Done: " + str + "</h2>");
		out.print("</body></html>");
		out.close();
		
	};
}
