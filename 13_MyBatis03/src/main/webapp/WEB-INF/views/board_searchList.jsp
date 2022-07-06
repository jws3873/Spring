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
	<c:set var="list" value="${searchPageList}"/>
	<div align="center">
		<hr width="50%" color="marmoon">
		<h3>BOARD 테이블 게시글 검색 리스트 페이지</h3>
		<hr width="50%" color="marmoon">
		<br>
		
		<table border="1" cellspacing="0" width="500">
		<tr>
			<th>게시글 No. </th> <th>글제목 </th>
			<th>작성자</th> <th>조회수</th> <th>작성일자</th>
		</tr>
		
		<c:if test="${!empty list }">
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.getBoard_no()}</td>
			<td>${dto.getBoard_title()}</td>
			<td>${dto.getBoard_writer()}</td>
			<td>${dto.getBoard_hit()}</td>
			<td>${dto.getBoard_date()}</td>
		</tr>		
		</c:forEach>
		</c:if>
		
		<c:if test="${empty list }">
		<tr>
			<td colspan="5" align="center">		
				<h3>검색된 게시물이 없습니다......</h3>
			</td>
		</tr>
		</c:if>
		
		<tr>
			<td colspan="5" align="right">		
				<input type="button" value="전체목록"
				onclick="location.href='board_list.do'">
			</td>
		</tr>

		</table>
		
		<!-- 검색 관련 페이지 처리 부분 -->

		<c:if test="${Paging.getPage() > Paging.getBlock() }">
		<a href="board_search.do?page=1&field=${Paging.getField()}&keyword=${Paging.getKeyword()}">[처음]</a>
		<a href="board_search.do?page=${Paging.getStartBlock() - 1}&field=${Paging.getField()}&eyword=${Paging.getKeyword()}">[Prev]</a>	
		</c:if>
	
		<c:forEach begin="${Paging.startBlock }" end="${Paging.endBlock }" var="i">
		<c:if test="${i == Paging.getPage() }">
			<b><a href="board_search.do?page=${i }&field=${Paging.getField()}&keyword=${Paging.getKeyword()}">[${i }]</a></b>
		</c:if>
		<c:if test="${i != Paging.getPage() }">
			<a href="board_search.do?page=${i }&field=${Paging.getField()}&keyword=${Paging.getKeyword()}">[${i }]</a>
		</c:if>
		</c:forEach>
	
		<c:if test="${Paging.getBlock() < Paging.getAllPage() }">
		<a href="board_search.do?page=${Paging.getEndBlock() +1 }&field=${Paging.getField()}&keyword=${Paging.getKeyword()}">[Next]</a>
		<a href="board_search.do?page=${Paging.getAllPage()}&field=${Paging.getField()}&keyword=${Paging.getKeyword()}">[마지막]</a>
		</c:if> 
	
	</div>
</body>
</html>