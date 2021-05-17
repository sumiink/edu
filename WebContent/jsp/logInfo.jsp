<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "logInOut.jsp">로그인페이지</a>
	<%
	//db조회 후 가져온 member 확인 후 이름, 나이를 출력
	//							없으면 "해당사용자없음."
	%>
	<%
	//String 객체 ==>equals
	if (request.getMethod().equals("POST")) {//POST로그인

		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");

		Member member = dao.checkInfo(id, pw);

		if (member == null | member.getMemberId()==null) {
			out.print("<h3>사용자정보없음</h3>");
		} else {
			session.setAttribute("info", member);
			out.print("이름:" + member.getMemberName() + "나이" + member.getMemberAge());
		}
	} else {//GET => 로그아웃
		session.invalidate();
		out.print("로그아웃 됨");
	}
	%>

</body>
</html>