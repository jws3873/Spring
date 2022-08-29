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
		<hr width="50%" color="red">
			<h3>EMP테이블 사원 상세 정보 화면</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="350">
		<c:set var="dto" value="${Cont}"/>
			<tr>
				<th>사원 No.</th>
				<td>${dto.getEmpno() }</td>
			</tr>
			
			<tr>
				<th>사원명</th>
				<td>${dto.getEname() }</td>
			</tr>
			
			<tr>
				<th>담당업무</th>
				<td>${dto.getJob() }</td>
			</tr>
			
			<tr>
				<th>관리자 No.</th>
				<td>${dto.getMgr() }</td>
			</tr>
			
			<tr>
				<th>급여</th>
				<td>${dto.getSal() }</td>
			</tr>
			
			<tr>
				<th>보너스</th>
				<td>${dto.getComm() }</td>
			</tr>
			
			<tr>
				<th>부서번호</th>
				<td>${dto.getDeptno() }</td>
			</tr>
			
			<tr>
				<th>입사일자</th>
				<td>${dto.getHiredate() }</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="사원 수정"
					onclick="location.href='emp_modify.do?num=${dto.getEmpno()}'">
					<input type="button" value="사원 삭제"
					onclick="if(confirm('정말로 삭제하시겠습니까?')){
						location.href='emp_delte.do?num=${dto.getEmpno()}'
					}else{return ;}">
					<input type="button" value="사원목록"
					onclick="location.href='emp_list.do'">
				</td>
			
			</tr>
			
			
		</table>
	</div>
</body>
</html>