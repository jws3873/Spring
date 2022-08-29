<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="uploadlist" value="${uploadList }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div align="center">
		<hr width="30%" color="red">
			<h3>UPLOAD테이블 전체 리스트 페이지</h3>
		<hr width="30%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="350">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>조회수</th>
				<th>작성일자</th>
			</tr>
			
			<c:if test="${!empty uploadlist }">
			<c:forEach items="${uploadlist }" var="dto">
				<tr>
					<td>${dto.upload_no}</td>
					<td> <a href="<c:url value='upload_detail.do?no=${dto.upload_no }'/>">
					${dto.upload_title}</a></td>
					<td>${dto.upload_hit}</td>
					<td>${dto.upload_date.substring(0,10)}</td>
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty uploadlist }">
			<tr>
				<td colspan="4" align="center">
					<h3>검색된 데이터가 없습니다 .....</h3>
				</td>
			</tr>
			</c:if>
			
			<tr>
				<td colspan="4" align="right">
					<input type="button" id="writeBtn" value="글쓰기">
				</td>
			</tr>
		</table>
	</div>
</body>

<script type="text/javascript">
	$(function(){
		$('#writeBtn').on("click",function(){
			location.href="<c:url value='upload_write.do'/>"
		});
	});
</script>
</html>