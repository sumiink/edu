<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="example03.jsp" %>

<%
	String name = request.getParameter("id");
	if(name.equals("user")){
		name =  "정상처리됨.";
	}
	out.print(name);
%>