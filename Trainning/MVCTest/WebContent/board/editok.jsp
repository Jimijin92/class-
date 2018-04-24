<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
</style>
<script>
	<c:if test="${result == 1}">
	location.href = "/mvc/board/view.do?seq=${seq}";
	</c:if>
	
	<c:if test="${result == 0}">
	alert("글수정하기를 실패했습니다.");
	history.back();
	</c:if>

	<c:if test="${result == 2}">
	alert("수정할 권한이 없습니다.");
	history.back();
	</c:if>

	
</script>
</head>
<body>
	<!-- editok.jsp -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		
		<h2 class="page-header">게시판 <small>글수정하기</small></h2>
		
		
		
	</div>

</body>
</html>
