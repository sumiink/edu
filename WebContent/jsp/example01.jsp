<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example01.jsp</title>
</head>
<body>
	<%!String name; //필드(멤버변수)
	//메소드 정의

	public int sum(int a, int b) {
		return a + b;
	}
	%>
<%
	//주석 
	/* 
	
	*/
	
	String user = request.getParameter("name");
	if (user == null) {
		user = "Guest";
	}
	int result = sum(10, 20);
%>

	<h1>Hello<%=user%></h1>
	<h2>결과: <%=result%></h2>
	<!--  -->
</body>
</html>