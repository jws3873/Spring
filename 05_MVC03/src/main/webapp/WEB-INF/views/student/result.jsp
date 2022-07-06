<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="gray">
			<h3>학생 성적 결과 폼 페이지</h3>
		<hr width="50%" color="gray">
		<br>
		<table border="1" cellspacing="0" width="350">
			<tr>
				<th>학생이름 : </th>
				<td>${studentName }</td>
			</tr>
			
			<tr>
				<th>국어점수 : </th>
				<td>${kor }</td>
			</tr>
			
			<tr>
				<th>영어점수 : </th>
				<td>${eng }</td>
			</tr>
			
			<tr>
				<th>수학점수 : </th>
				<td>${math }</td>
			</tr>
			
			<tr>
				<th>총점 : </th>
				<td>${total }</td>
			</tr>
			
			<tr>
				<th>평균 : </th>
				<td>${avg } </td>
			</tr>
			
			
		</table>
	</div>
</body>
</html>