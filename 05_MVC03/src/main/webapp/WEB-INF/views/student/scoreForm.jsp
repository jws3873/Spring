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
		<hr width="50%" color="red">
		<h3>학생 성적처리 폼 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<form method="get" action="<%=request.getContextPath()%>/studentOk">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>학생이름 : </th>
					<td> 
						<input type="text" name="name">
					</td >
				</tr>
				
				<tr>
					<th>국어점수 : </th>
					<td> 
						<input type="text" name="kor">
					</td >
				</tr>
				
				<tr>
					<th>영어점수 : </th>
					<td> 
						<input type="text" name="eng">
					</td >
				</tr>
				
				<tr>
					<th>수학점수 : </th>
					<td> 
						<input type="text" name="math">
					</td >
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="제출"> &nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>	
			
			</table>
		
		</form>
		
		
	
	</div>
</body>
</html>