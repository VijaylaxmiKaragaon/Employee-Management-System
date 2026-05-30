
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:yellow">
<h1>JSP Demo</h1>
  <%Date d=new Date(); %>
  <h3><%= d %></h3>
  
  <%Random rd=new Random(); %>
  <%Long randomValue=rd.nextLong()*8; %>
   <h5 style="color:red"><%=randomValue %></h5>

</body>
</html>