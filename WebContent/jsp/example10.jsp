<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example10.jsp</title>
</head>
<body>

	<%
	//request=> container값
	String rid =null;
	String name = null;
	int age = 0;
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	if(id == null){
		id = (String)session.getAttribute("id");
	}
	if(pwd == null){
		pwd = (String)session.getAttribute("pwd");
	}
	if (id.isEmpty() || pwd.isEmpty()) {
		request.setAttribute("err", "ID, 비밀번호를 입력하시오");
		RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
		rd.forward(request, response);
		return;
	}
	//로그인 처리
	if(session.isNew() || session.getAttribute("id") == null){
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", "홍길동");
		session.setAttribute("age", 15);
		out.print("로그인 작업이 완료");
	}else{
		out.print("이미 로그인 상태.");
		rid = (String)session.getAttribute("id");
		name = (String)session.getAttribute("name");
		age = (int)session.getAttribute("age");
		
	}
	%>
	<h3>
		아이디:
		<%=id%></h3>
	<h3>
		비밀번호:
		<%=pwd%></h3>
	<h3>Welcome: <%=name %></h3>
</body>
</html>