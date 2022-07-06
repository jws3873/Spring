<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<hr width="30%" color="tomato">
		<h3>회원 가입 정보 페이지</h3>
	<hr width="30%" color="tomato">
	<br>
	
	<table border="1" cellspacing="0" width="350">
	<c:set var="dto" value="${DTO }"></c:set>
	<c:if test="${!empty dto }">
	<tr>
		<th>회원 이름 : </th>
		<td> ${dto.getName() }</td>
	</tr>
	
	<tr>
		<th>회원 아이디 : </th>
		<td> ${dto.getId() }</td>
	</tr>
	
	<tr>
		<th>회원 비밀번호 : </th>
		<td> ${dto.getPwd() }</td>
	</tr>
	
	<tr>
		<th>회원 나이 : </th>
		<td> ${dto.getAge() }</td>
	</tr>
	
	<tr>
		<th>회원 연락처 : </th>
		<td> ${dto.getPhone() }</td>
	</tr>
	
	<tr>
		<th>회원 이메일 : </th>
		<td> ${dto.getEmail() }</td>
	</tr>
	
	<tr>
		<th>회원 주소 : </th>
		<td> ${dto.getAddr() }</td>
	</tr>
	</c:if>
	
	<c:if test="${empty dto }">
		<tr>
			<td colspan="2" align="center">
				<h3>입력된 회원 정보가 없습니다.....</h3>
			</td>		
		</tr>
	</c:if>
	
	</table>
	
	</div>
</body>
</html>