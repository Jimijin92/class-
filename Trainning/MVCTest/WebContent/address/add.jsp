<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

</style>
<script>
	$(function(){
		
	});
</script>

</head>
<body>
<!--add.jsp -->
<%

//int n =0;
//int m = 100 /n;

//첫번째 알바생인 서블릿은 잘못안하고 얘가 잘못하는 상황
//An exception occurred processing [/address/add.jsp] at line [26]
		//명확하게 jsp에서 잘못한거라고 알려줌!! 
%>

<div class = "container">
	<h1 class="page-header">주소록 <small>등록하기</small></h1>
	
	<!-- <form method="post" action="/MVCTest/addok.jsp" > --><!-- 진짜페이지일때는 이 표현 가능 -->
	<!-- <form method="post" action="/MVCTest/address/addok.do" > --><!-- 가짜페이진데 어떻게 연결? webxml에서는  /address/add.do 중에 첫번째 /가 WebContent나타냄-->
	<form method="post" action="/mvc/address/addok.do" ><!-- 컨텍스트 루트, 컨텍스트 패스 를 mvc로 바꿔줌 (tomcat->더블클릭->모듈->MVCTest->edit->mvc) -->
	
	<!-- 절대로 주소 끝에 jsp로 끝나는 경우 없어야 함!!!! 항상 서블릿(자바)로 가서 실행해야함  -->
	
	
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" required></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="gender" >
						<option value="m">남자</option>
						<option value="f">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="text" name="tel" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" required></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록하기">
		</div>
	</form>
</div>









</body>
</html>