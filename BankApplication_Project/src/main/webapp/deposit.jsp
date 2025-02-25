<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String dep = (String)request.getAttribute("dep");
%>
<h3><%=dep %></h3>
<%@include file="Dashboard.html" %>
</body>
</html>