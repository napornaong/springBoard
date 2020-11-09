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
	<div class="container">
		<h2>회원가입</h2>
		<form action="join.do" method="post" class="form-group"name=frm>
		<table class="table" >
			<tr>
				<th>id</th>
				<c:if test="${!empty idck }">
				<td><input class="form-control" name="id" id="id" placeholder="id입력"  value="${inputid }" required readonly="readonly"/>
				</c:if> 
				<c:if test="${empty idck }">
				<td><input class="form-control" name="id" id="id" placeholder="id입력"  value="${inputid }" required/>
				<input type="button" value="중복확인" onclick="location.href='sameid.do?inputid='+document.frm.id.value"/> 
				</td>
				</c:if>
			</tr>
			
			<tr>
				<th>pw</th>
				<td><input class="form-control" name="pw"></input></td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td><input class="form-control" name="pnum"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input class="form-control" name="name"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit"></input>
				<input type="reset"></input>
				<button type="button" class="cancelBtn">취소</button>
				</td>
			</tr>
		
		</table>
		</form>
	</div>