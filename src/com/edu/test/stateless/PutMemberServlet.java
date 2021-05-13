package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// db에서 리스트  => memberList.jsp
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		
		RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//parameter를 읽어들여 db에 insert,  입력한 요청정보를 memberResult.jsp로 결과 전달
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		MemberDAO dao = new MemberDAO();
		//System.out.println("db에 입력되었습니다.");
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setMemberPwd(pwd);
		member.setMemberAge(Integer.parseInt(age));
		dao.insertMember(member);
		
		//this.getServletContext();		//ServletContext의 requestdispathcer객체호출
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp");
		req.setAttribute("member", member);
		rd.forward(req, resp);
		
		
	}
}
