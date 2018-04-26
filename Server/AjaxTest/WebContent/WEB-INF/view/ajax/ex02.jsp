<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

	.item{margin: 10px; padding: 5px; text-align: right; border-left: 5px solid #ccc; padding-right: 10px; border-top-radius: 50%; border-bottom-right-radius: 10px;}
	

</style>
<script>


</script>
</head>
<body>
	<!-- "WebContent/ajax/ex01.jsp" -->
	<!-- 뷰 역할 -->

	
	<div class="container">
		<h2 class="page-header">설문조사</h2>
	
		<div class="panel panel-default">
			<div class="panel-heading" id="question"></div>
			<div class="panel-body">
				<div class="item bg-info" id="item1"><span></span><span class="badge"></span></div>
				<div class="item bg-success" id="item2"><span></span><span class="badge"></span></div>
				<div class="item bg-warning" id="item3"><span></span><span class="badge"></span></div>
				<div class="item bg-warning" id="item4"><span></span><span class="badge"></span></div>
				<div></div>
			</div>
		</div>
	
		<hr>
		
		<h2 class="page-header">추가내용</h2>
		<input type="text" class="form-control">
	
	</div>
	style="display:none;
	<iframe src = "/ajax/ex02data.do" ></iframe>
	
</body>
</html>