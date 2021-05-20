<%@page import="com.edu.member.model.MemberService"%>
<%@page import="com.edu.member.model.MemberVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 입력을 받아 -> DB에 저장 -> 처리결과(memberOutput.jsp)보여줌
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPasswd(passwd);
	member.setName(name);
	member.setMail(mail);
	
	//서비스 로직(MemberService.java)
	//DB처리(MemberDAO.java)
	MemberService service = new MemberService();
	service.memberInsert(member);
	
	request.setAttribute("member", member);
	
	//처리결과 memberOutput.jsp
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
	
%>