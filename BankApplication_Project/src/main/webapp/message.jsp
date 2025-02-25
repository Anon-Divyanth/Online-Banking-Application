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
int code = (Integer)request.getAttribute("code");
if(code == 1){
%>
<h3>Login failed.. please try again</h3>
<%@include file="login.html"%>
<%}
else if(code == 2){
%>
<%@include file="Dashboard.html" %>
<%}
else if(code == 3){
%>
<script type="text/javascript">alert("Session Expired. Please login again")</script>
<%@include file="HomePage.html" %>
<%}
else if(code == 4){
%>
<h3>Wrong Pin</h3>
<%@include file="deposit.html" %>
<%}
else if(code == 5){
%>
<h3>Wrong Pin</h3>
<%@include file="withdraw.html" %>
<%} %>
</body>
</html>