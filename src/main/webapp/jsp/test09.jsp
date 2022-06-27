<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘부터 1일</title>
</head>
<body>


<div>
	<h3>오늘부터 1일</h3>
	
	
	<%
	Calendar today = Calendar.getInstance();
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 M월 d일");
	
	String dateString = formatter.format(today.getTime());
	today.add(Calendar.DATE,99);
	dateString = formatter.format(today.getTime());
	
	%>
	
	
	<% for(int i= 1; i<1000; i+=100){
		today.add(Calendar.DATE,i-1);
		dateString = formatter.format(today.getTime());
	%>
	<div><%=i+99 %>일: <span> <%= dateString %></span></div>
	<%} %>
</div>
	

</body>
</html>