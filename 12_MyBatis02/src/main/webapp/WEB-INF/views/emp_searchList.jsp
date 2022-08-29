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
		<c:set var="list" value="${searchList }"/>
		<hr width="50%" color="red">
		<h3>EMP 테이블 검색 리스트</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="350">
		<tr>
			<th>사원 No.</th> <th>이름</th>
			<th>부서 No.</th> <th>입사일자</th>
		</tr>
		
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.empno }</td>
					<td>${dto.ename }</td>
					<td>${dto.deptno }</td>
					<td>${dto.hiredate.substring(0,10) }</td>
				</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty list }">
			<tr>
				<td colspan="4" align="center">
					<h3>검색된 회원 리스트가 없습니다.</h3>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="전체목록"
				onclick="location.href='emp_list.do'">
			</td>
		</tr>
		</table>
	</div>
</body>
</html>