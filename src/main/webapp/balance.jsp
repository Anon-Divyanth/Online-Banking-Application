<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.UserBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Roboto', sans-serif;
            line-height: 1.5;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        ul {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px 40px;
            max-width: 400px;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); 
            list-style: none;
            text-align: center;
        }

        li {
            font-size: 24px;
            font-weight: bold;
            color: #007bff;
            margin: 0;
        }

        h3 {
            text-align: center;
            margin-top: 20px;
            color: #d9534f;
            font-size: 24px;
        }
    </style>
</head>
<body>
<%
UserBean ub = (UserBean) session.getAttribute("session");
if (ub == null) {
%>
	<script type="text/javascript">alert("Session Expired. Please login again")</script>
    <%@ include file="HomePage.html" %>
<%
} else {
    long amount = ub.getAmount();
%>
    <%@ include file="Dashboard.html" %>
    <ul>
        <li>Current Balance: ₹ <%= amount %></li>
    </ul>
<%
}
%>
</body>
</html>
