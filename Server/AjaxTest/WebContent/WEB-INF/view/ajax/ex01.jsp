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

	$(function(){
		$("#item1").css("width","${dto.cnt1*20}px");
		$("#item2").css("width","${dto.cnt2*20}px");
		$("#item3").css("width","${dto.cnt3*20}px");
		$("#item4").css("width","${dto.cnt4*20}px");

		setTimeout(function(){
			location.reload();
		}, 5000);
		
	});

</script>
</head>
<body>
	<!-- "WebContent/ajax/ex01.jsp" -->
	<!-- 뷰 역할 -->

	
	<div class="container">
		<h2 class="page-header">설문조사</h2>
	
		<div class="panel panel-default">
			<div class="panel-heading">${dto.question}</div>
			<div class="panel-body">
				<div class="item bg-info" id="item1">${dto.answer1} <span class="badge">${dto.cnt1}</span></div>
				<div class="item bg-success" id="item2">${dto.answer2} <span class="badge">${dto.cnt2}</span></div>
				<div class="item bg-warning" id="item3">${dto.answer3} <span class="badge">${dto.cnt3}</span></div>
				<div class="item bg-warning" id="item4">${dto.answer4} <span class="badge">${dto.cnt4}</span></div>
				<div></div>
			</div>
		</div>
	
		<hr>
		
		<h2 class="page-header">추가내용</h2>
		<input type="text" class="form-control">
	
	
	</div>
	
</body>
</html>