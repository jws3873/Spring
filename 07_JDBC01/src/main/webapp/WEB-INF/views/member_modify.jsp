<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${Modify }"/>
		<hr width="50%" color="blue"> 
		<h3>MEMBER10 테이블 ${dto.getMemname() }회원정보 수정 폼 페이지</h3>
		<hr width="50%" color="blue"> 
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/member_modify_ok.do">
		<input type="hidden" name="num" value="${dto.getNum() }">
		<input type="hidden" name="user_pwd" value="${dto.getPwd() }">
		<table border="1" cellspacing="0" width="350">
		<tr>
			<th>회원 아이디 </th>
			<td>
				<input type="text" name="memid" value="${dto.getMemid() }" readonly>
			</td>
		</tr>
		
		<tr>
			<th>회원 이름 </th>
			<td>
				<input type="text" name="memname" value="${dto.getMemname() }" readonly>
			</td>
		</tr>
		
		<tr>
			<th>회원 비밀번호 </th>
			<td>
				<input type="password" name="pwd" value="${dto.getPwd() }" readonly>
			</td>
		</tr>
		
		<tr>
			<th>회원 나이 </th>
			<td>
				<input type="text" name="age" value="${dto.getAge() }">
			</td>
		</tr>
		
		<tr>
			<th>회원 마일리지 </th>
			<td>
				<input type="text" name="mileage" value="${dto.getMileage() }">
			</td>
		</tr>
		
		<tr>
			<th>회원 직업 </th>
			<td>
				<input type="text" name="job" value="${dto.getJob() }">
			</td>
		</tr>
		
		<tr>
			<th>회원 주소 </th>
			<td>
				<input type="text" name="addr" value="${dto.getAddr() }">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="정보수정"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시작성">
			</td>
		</tr>
		
		</table>
		</form>
	</div>
</body>
</html>