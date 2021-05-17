<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exmaple12.jsp</title>
</head>
<body>
<%!
	public void work(String p, PageContext pc){
	try{
	JspWriter out =pc.getOut();
	if(p.equals("include")){
		out.print("inclued전");
		pc.include("example15.jsp");
	}else if(p.equals("forward")){
		pc.forward("example05.jsp");
	}
}catch(Exception e){
	System.out.println("오류발생");
}
}
%>
<%
	String p = request.getParameter("p");
	this.work(p, pageContext);
%>
</body>
</html>