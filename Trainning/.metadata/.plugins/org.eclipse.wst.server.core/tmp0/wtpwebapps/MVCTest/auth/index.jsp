<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>



<style>
</style>
<script>
	
</script>
</head>
<body>
<!-- 갖다쓸때는 보통 id 안씀 , 유일해서 충돌날까봐, class는 씀.. -->
	<!-- "WebContent/auth/index.jsp" -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		<h2 class="page-header">회원 인증(auth.index.jsp) <small>${auth}</small></h2>
		
		<div>
			<h3>로그인</h3>
			<input type="button" value="홍길동(일반 회원)" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?id=hong&pw=1111&lv=1';">
			<input type="button" value="테스트(일반 회원)" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?id=test&pw=1111&lv=1';">
			
			<input type="button" value="고양이(중간 관리자)" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?id=cat&pw=1111&lv=2';">
			<input type="button" value="강아지(중간 관리자)" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?id=dog&pw=1111&lv=2';">

			<input type="button" value="관리자(최고관리자)" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?id=admin&pw=1111&lv=3';">
		</div>
		
		<div>
			<h3>로그아웃</h3>
			<input type="button" value="로그아웃" class="btn btn-default"
			onclick="location.href='/mvc/auth/login.do?mode=off';">
		</div>
		
		
		
	</div>
</body>
</html>



