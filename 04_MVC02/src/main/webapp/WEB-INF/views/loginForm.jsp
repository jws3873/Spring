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
			<h3>로그인 폼 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<form method="get" action="<%=request.getContextPath()%>/loginOk">
		<table border="1" cellspacing="0">
			<tr>
				<th>아이디 </th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호 </th>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시작성">
				</td>
			</tr>
		
		</table>
		
		</form>
	
	</div>
</body>
</html>