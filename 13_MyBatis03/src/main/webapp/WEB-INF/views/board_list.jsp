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
	<c:set var="list" value="${List }"/> 
	<c:set var="paging" value="${Paging }"/> 
	<div align="center">
		<hr width="50%" color="red">
		<h3>BOARD테이블 전체 리스트 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="500">
			<tr>
				<th>게시글 No.</th> <th>글 제목</th> 
				<th>작성자</th> <th>조회수</th> <th>작성일자</th>
			</tr>
			
				<c:if test="${!empty list}">
					<c:forEach items="${list }" var="i">
					<tr>
						<td>${i.board_no }</td>
						<td><a href="<%=request.getContextPath()%>/board_content.do?no=${i.board_no }&page=${paging.page}">
						${i.board_title }</a></td>
						<td>${i.board_writer }</td>
						<td>${i.board_hit }</td>
						<td>${i.board_date.substring(0,10) }</td>
					</tr>
					</c:forEach>				
				</c:if>
			
			<c:if test="${empty list }">
				<tr>		
					<td colspan="5" align="center">
						<h3>전체 게시물 목록이 없습니다....</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="5" align="right">
					<input type="button" value="게시물 작성"
					onclick="location.href='board_write.do'">
				</td>
			</tr>
		</table>
		<br> <br>
		
		<!-- 페이징 처리 부분 -->
		<c:if test="${paging.page > paging.block }">
		<a href="board_list.do?page=1">[처음]</a>
		<a href="board_list.do?page=${paging.startBlock -1 }">[pre]</a>
		</c:if>
		
		<c:forEach begin="${paging.startBlock}" end="${paging.endBlock }" var="i">
		<c:if test="${paging.page == i }">
		<b> <a href="board_list.do?page=${i }">[${i }]</a></b>		
		</c:if>
		<c:if test="${paging.page != i }">
		<a href="board_list.do?page=${i }">[${i }]</a>		
		</c:if>
		</c:forEach>
		
		<c:if test="${paging.endBlock < paging.allPage }">
		<a href="board_list.do?page=${paging.endBlock+1 }">[next]</a>
		<a href="board_list.do?page=${paging.allPage }">[마지막]</a>
		</c:if>
		
		<br><br>
		
		<form method="post" action="<%=request.getContextPath()%>/board_search.do">
		<input type="hidden" name="page" value="${Paging.getPage() }">
		<select name="field">
		<option value="title">제목</option>
		<option value="cont">내용</option>
		<option value="title_cont">제목+내용</option>
		<option value="writer">작성자</option>
		</select>
		
		<input type="text" name="keyword">
		<input type="submit" value="검색">
		
		</form>
	</div>
</body>
</html>