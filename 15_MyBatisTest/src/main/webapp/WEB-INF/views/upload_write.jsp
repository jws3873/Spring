<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="balck">
		<h3>UPLOAD 테이블 글쓰기 폼 페이지</h3>
		<hr width="50%" color="balck">
		<br>
		
		<form method="post" enctype="multipart/form-data" action="<c:url value="upload_write_ok.do"/>">
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="upload_writer">
					</td>
				</tr>
				
				<tr>
					<th>글제목</th>
					<td>
						<input type="text" name="upload_title">
					</td>
				</tr>
				
				<tr>
					<th>글내용</th>
					<td>
						<textarea rows="7" cols="20" name="upload_cont"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="file1">
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="upload_pwd">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>