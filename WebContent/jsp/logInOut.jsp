<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- logInfo.jsp id, pwd 입력 -memberDAO.checkInfo(id,pwd): member정보 return - name, age 내용보여주는 logInfo.jsp: 사용자 정보가 없습니다." -->
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/logInOut.jsp</title>
</head>
<body>
<% 
	String msg = (String)request.getAttribute("err");
	if(msg == null) {
		msg = "";
	}
%>
<%=msg %>
	<form action="logInfo.jsp" method="post">
		ID: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>