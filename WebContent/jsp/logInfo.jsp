<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//db조회 후 가져온 member 확인 후 이름, 나이를 출력
//							없으면 "해당사용자없음."

String nam= null;
int age = 0;

String id =request.getParameter("id");
String pw =request.getParameter("pwd");

if(id == null){
	id= (String)session.getAttribute("id");
}


%>

</body>
</html>