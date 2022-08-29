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
		<hr width="50%" color="blue">
			<h3>파일 업로드 폼 페이지</h3>
		<hr width="50%" color="blue">
		<br>

		<form method="post" enctype="multipart/form-data" action="<c:url value='upload_ok.do'/>">
			<table border="1" cellspacing="0" width="400" >
				<tr>
					<th>첨부파일</th>
					<td> <input type="file" multiple="multiple" name="file"> </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="파일전송"> &nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		
		</form>
	</div>
</body>
</html>