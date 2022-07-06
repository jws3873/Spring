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
	<h3>BOARD 테이블 전체 리스트 페이지</h3>
	<hr width="50%" color="red">
	<br>
	<table border="1" cellspacing="0" width="400">
	<tr>
		<th>글번호</th> <th>글제목</th>
		<th>조회수</th> <th>작성일자</th>
	</tr>
	
	<c:set var="list" value="${searchList }"/>
	<c:if test="${!empty list }">
	<c:forEach items="${list }" var="dto">
	<tr>
		<td>${dto.getBoard_no() }</td>	
		<td>${dto.getBoard_title() }</td>	
		<td>${dto.getBoard_hit() }</td>	
		<td>${dto.getBoard_date().substring(0,10) }</td>	
	</tr>
	</c:forEach>
	</c:if>
	
	<c:if test="${empty list }">
	<tr>
		<td colspan="4" align="center">
			<h3>검색된 데이터가 없습니다.</h3>
		</td>	
	</tr>
	</c:if>
	
	<tr>
		<td colspan="4" align="right">
			<input type="button" value="전체목록"
			onclick="location.href='board_list.do'">
		</td>
	</tr>
	</table>
	
	<br>
	
	<c:if test="${page > block }">
		<a href="<%=request.getContextPath()%>/board_search.do?page=1&filed=${field}&keyword=${keyword}">◀◀</a>
		<a href="<%=request.getContextPath()%>/board_search.do?page=${startBlock-1}&field=${field}&keyword=${keyword}">◀</a>
	</c:if>
	
	<c:forEach begin="${startBlock}" end="${endBlock }" var="i">
		<c:if test="${i == page }">
		<b> <a href="<%=request.getContextPath()%>/board_search.do?page=${i}&field=${field}&keyword=${keyword}">[${i}]</a> </b>
		</c:if>
		<c:if test="${i != page }">
		<a href="<%=request.getContextPath()%>/board_search.do?page=${i}&field=${field}&keyword=${keyword}">[${i}]</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${endBlock < allPage }">
		<a href="<%=request.getContextPath()%>/board_list.do?page=${endBlock +1}&field=${field}&keyword=${keyword}">▶</a>
		<a href="<%=request.getContextPath()%>/board_list.do?page=${allPage}&field=${field}&keyword=${keyword}">▶▶</a>
	</c:if>
	
	<br><br>
	
	<form method="post" action="<%=request.getContextPath()%>/board_search.do">
	<select name="field">
	<option value="title">제목 </option>
	<option value="content">내용 </option>
	<option value="title_content">제목+내용 </option>
	</select>
	
	<input name="keyword">
	<input type="submit" value="검색">
	</form>
	
	</div>
</body>
</html>