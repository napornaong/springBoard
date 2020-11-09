<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id체크</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".cancelBtn").click(function() {
			history.back();
		});
	});
	
</script>
</head>
<body>
	<div class="container">
		<h2>id체크</h2>
	
		<table class="table" >
			<tr>
				<th>id</th>
				<td><input class="form-control" name="id" id="id" value="${inputid}" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
				<input type="button" value="중복확인" onclick="location.href='sameidck.do?id='+document.getElementById('id').value"></input>
				<button type="button" class="cancelBtn">취소</button></td>
				</tr>
		
				<tr>
				<td><c:if test="${result==0 }">
					${inputid }는 사용할수 있습니다.
					<br>
					<input type="button" value="사용하기" onclick="location.href='join.do?inputid=${inputid}&idck=ok'"/>	
					<button type="button" class="cancelBtn">취소</button></td>				
				</c:if></td>
				<td><c:if test="${result==1 }">
					<p>${inputid }는 동일한 아이디가 있습니다</p>
					<button type="button" class="cancelBtn">취소</button></td>
				</c:if></td>
				</tr>
	</table>
	</div>