<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".cancelBtn").click(function(){
		history.back();
	});
});

</script>	
</head>
<body>
<c:set var="nook" value="${nook }"/>
		<c:if test="${nook eq 'nook' }">
		<script >
		alert("아이디가 없거나 비밀번호가 틀립니다")
		</script>
		</c:if>
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" class="form-group">
		<table class="table">
			<tr>
				<th>id</th>
				<td><input class="form-control" name="id"/></td>
			</tr>
			
			<tr>
				<th>pw</th>
				<td><input class="form-control" name="pw"/></td>
			</tr>
			
			
			<tr>
				<td colspan="1">
				<input type="submit" value="로그인" >
			
				<button type="button" class="cancelBtn">취소</button>
				</td>
			</tr>
		
		</table>
		</form>
		
	</div>