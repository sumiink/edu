<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록(memberInput.jsp)</title>
</head>
<body>
<form action="memberProc.do" method="post">
	ID: <input type="text" name="id"><br>
	PW: <input type="password" name="passwd"><br>
	Name: <input type="text" name="name"><br>
	Mail:<input type="email" name="mail"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>