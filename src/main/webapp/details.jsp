<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.UserBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
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
            color: red;
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
            <%@include file="HomePage.html" %>
        <%
        } else {
            // Extracting user data from the session
            Long acc = ub.getAcc_num();
            String user = ub.getUsername();
            Long phn = ub.getPhn();
            String addr = ub.getAddress();
            int pin = ub.getPin();
        %>
        
           <%@include file="Dashboard.html" %><
            <!-- Display user data -->
            
            <ul>
            	<h3>User Information</h3>
                <li><strong>Account Number:</strong> <%= acc %></li>
                <li><strong>Username:</strong> <%= user %></li>
                <li><strong>PIN:</strong> <%= pin %></li>
                <li><strong>Phone Number:</strong> <%= phn %></li>
                <li><strong>Address:</strong> <%= addr %></li>
            </ul>

        <%
        }
        %>

      
</body>
</html>
