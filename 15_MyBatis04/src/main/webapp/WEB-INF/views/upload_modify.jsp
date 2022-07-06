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
		<c:set var="dto" value="${Modify }"/>
		<hr width="50%" color="red">
			<h3>${dto.upload_writer }님 게시글 수정 폼 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/upload_modify_ok.do">
		<input type="hidden" name="upload_no" value="${dto.upload_no}">
		<input type="hidden" name="pwd" value="${dto.upload_pwd}">
		<table border="1" cellspacing="0" width="350">
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="upload_writer" value="${dto.upload_writer }" readonly>
				</td>
			</tr>
			
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="upload_title" value="${dto.upload_title }">
				</td>
			</tr>
			
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="3" cols="30" name="upload_cont">${dto.upload_cont }</textarea>
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
					<input type="submit" value="게시글 수정"> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시작성">
				</td>
			</tr>
		
		</table>
		</form>
		
	</div>

</body>
</html>