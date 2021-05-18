<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/bookOutput.jsp</title>
</head>
<body>
<%
BookBean book = (BookBean)request.getAttribute("book");
%> 

<h1>정상적으로 처리되었습니다.</h1>
<p>책제목: ${book.title }</p><%=book.getTitle() %>
<p>책저자: ${book.author }</p><%=book.getAuthor() %>
<p>출판사: ${book.publisher }</p><%=book.getPublisher() %>
<p>toString: ${book }</p>
</body>
</html>