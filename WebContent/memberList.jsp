<%@page import="com.edu.test.stateless.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
	<ul>

		<%
		List<Member> list = (List<Member>) request.getAttribute("memberList");
		out.print("");
		//<tr><td>아이디</td><td>이름</td></tr>
		for (Member mem : list) {
			out.print("<table border='1'><tr><td>"+ mem.getMemberId() +"</td> <td>" +mem.getMemberName()+"</td> </tr></table>");
			//out.print("<li>" + mem.getMemberId() + ", " + mem.getMemberName() + "</li>");
		}
		%>
	</ul>
</body>
</html>