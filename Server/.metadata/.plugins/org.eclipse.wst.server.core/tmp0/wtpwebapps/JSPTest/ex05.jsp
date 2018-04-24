<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
		
<%@page import="com.test.jsp.MyUtil"%>

<%
	//변수: 멤버 변수? 지역변수? 
	int a=10;

	MyUtil util = new MyUtil();//패키지가 다르니까 유의해서 import (ctrl+space)

%>		
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ex05.jsp -->

<h1>구구단</h1>


<% for(int i=1; i<=9;i++){ %>

<div>9x<%=i %>=<%=i*9%></div>

<% } %>

<p><%=util.run() %></p>


</body>
</html>


<%
	int b= a;

	/* public void test(){} *///지역내에서는 클래스 만들수 x
%>

<%!//생성자 만들때 !붙이기
	int c =10;
	public void test(){
		
	}
%>

















