<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Example14</h3>
	<%
		String res = (String)application.getAttribute("welcomeMSG");
		request.setAttribute("result", res);
	%>
	<jsp:forward page="example05.jsp"></jsp:forward>

<%
	//RequestDispatcher rd = request.getRequestDispatcher("example12.jsp");
	//rd.forward(request, response);
%>
</body>
</html>