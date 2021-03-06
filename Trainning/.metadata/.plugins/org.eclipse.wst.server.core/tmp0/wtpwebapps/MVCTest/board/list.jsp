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

	#tbl1 th:nth-child(1){width:70px;}
	#tbl1 th:nth-child(2){width:500px;}
	#tbl1 th:nth-child(3){width:120px;}
	#tbl1 th:nth-child(4){width:140px;}
	#tbl1 th:nth-child(5){width:70px;}
	#tbl1 th{text-align: center;}
	
	#tbl1 td{text-align:center;}
	#tbl1 td:nth-chlid(2) {text-align:left;}
	
	#tbl1 td span.label {font-size: 6px; padding: 1px;}

</style>
<script>
	
</script>
</head>
<body>
<!-- 갖다쓸때는 보통 id 안씀 , 유일해서 충돌날까봐, class는 씀.. -->
	<!-- list.jsp -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		<h2 class="page-header">게시판 <small>목록보기</small></h2>
		
		<!-- 27번 -->
		<table id="tbl1" class="table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>
					<a href="/mvc/board/view.do?seq=${dto.seq}">${dto.subject}</a>
					<c:if test="${dto.gap < 90}">
					<span class="label label-danger">new</span>
			</c:if>
				</td>
				<td>${dto.name}</td> 
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
			</tr>
			</c:forEach>
			
			
			
		</table>
		<!-- 시퀀스 객체의 캐쉬 설정때문에 게시글 번호 갑자기 점프하는 현상 생김(글 10개 쓴적 없는데 글번호 1번에서 11번됨)  -->
		
		
		
		
		<table id="tbl1" class="table table-striped">
		</table>
		
		<div id="btns">
			<input type="button" value="목록보기" class="btn btn-primary" onclick="location.href='/mvc/board/list.do';" />
			<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='/mvc/board/add.do';" />
		</div>
		
		
	</div>
</body>
</html>


























