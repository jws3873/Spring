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
		<h3>UPLOAD테이블 전체 리스트 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>글번호 </th> <th>글제목 </th>
				<th>조회수 </th> <th>작성일자 </th>
			</tr>
			<c:set var="list" value="${List }"/>
			<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.upload_no }</td>
					<td> <a href="<%=request.getContextPath()%>/upload_content.do?no=${dto.upload_no }">
					${dto.upload_title }</a></td>
					<td>${dto.upload_hit }</td>
					<td>${dto.upload_date }</td>
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>검색된 데이터가 없습니다.....</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글쓰기"
					onclick="location.href='upload_write.do'">
				</td>
			</tr>
		</table>

	</div>
</body>
</html>