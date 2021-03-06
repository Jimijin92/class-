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
	
	#tbl1 th { width: 150px; text-align: right; vertical-align: middle; padding-right: 15px; }
	#tbl1 td { width: 750px; padding-right: 50px; }
	#tbl1 #content { height: 350px; }

</style>
<script>

	$(function(){


		<%--주석표기 주의하기!!!! 
		//$("#subject").val("${dto.subject}");
		//$("#content").val("${dto.content}");
 		--%>

		});

</script>
</head>
<body>
	<!-- edit.jsp -->
	<div class="container">
	
		<jsp:include page="/inc/header.jsp"></jsp:include>
		
		<h2 class="page-header">게시판 <small>글수정하기</small></h2>
		
		<form method="post" action="/mvc/board/editok.do">
			<table id="tbl1" class="table table-striped">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" id="subject" class="form-control" required value="${dto.subject}"></td>					
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" class="form-control" required>${dto.content}</textarea></td>
				</tr>
				<tr>
					<th>태그</th>
					<td>
						<select name="tag" id="tag" class="form-control short">
							<option value="n" <c:if test="${dto.tag == 'n'}">selected</c:if>>적용안함</option>
							<option value="y" <c:if test="${dto.tag == 'y'}">selected</c:if>>적용함</option>
						</select>
					</td>
				</tr>
			</table>
			
			<div id="btns">
				<input type="button" value="뒤로가기" class="btn btn-default" onclick="history.back();">
				<input type="submit" value="글수정하기" class="btn btn-primary">	
			</div>
			
			<input type="hidden" name="seq" value="${dto.seq}">
		</form>
		
	</div>

</body>
</html>
































