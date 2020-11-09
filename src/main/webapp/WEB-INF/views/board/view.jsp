<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<h2>게시판글보기</h2>
		<form method="post" class="form-group">
		<table class="table">
			<tr>
				
				<th>번호</th>
				<td>${vo.no }</td>
			</tr>
			<tr>
				
				<th>제목</th>
				<td>${vo.title }</td>
			</tr>
			<tr>
				
				<th>내용</th>
				<td><pre>${vo.content }</pre></td>
			</tr>
			<tr>
				
				<th>작성자</th>
				<td>${vo.writer }</td>
			</tr>
			<tr>
				
				<th>작성일</th>
				<td><fmt:formatDate value="${vo.writeDate}" pattern="yyy.MM.dd"/> </td>
			</tr>
			<tr>
				
				<th>조회수</th>
				<td>${vo.hit }</td>
			</tr>
			
			<tr>
				<td colspan="2">
				<a href="update.do?no=${vo.no }" class="btn btn-defalt">수정</a>
				<a href="delete.do?no=${vo.no }" class="btn btn-defalt">삭제</a>
				<a href="list.do" class="btn btn-defalt">리스트</a>
				</td>
			</tr>

		</table>
		</form>
	</div>

</body>
</html>