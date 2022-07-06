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
	<c:set var="dto" value="${Cont }"/>
	<hr width="50%" color="red">
		<h3>${dto.getBoard_writer() }님 게시물 상세 내역 페이지</h3>
	<hr width="50%" color="red">
	<br>
	
	<table border="1" cellspacing="0" width="400">
		<tr>
			<th>작성자 </th>
			<td>${dto.board_writer}</td>
		</tr>
		
		<tr>
			<th>글제목 </th>
			<td>${dto.board_title}</td>
		</tr>
		
		<tr>
			<th>글내용 </th>
			<td>
				<textarea rows="7" cols="20">${dto.board_cont }</textarea>
			</td> 
		</tr>
		
		<tr>
			<th>조회수 </th>
			<td>${dto.board_hit}</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<c:if test="${!empty dto.board_pwd}">
				<c:forEach begin="1" end="${dto.board_pwd.length()}">
					*
				</c:forEach>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<c:if test="${empty dto.board_update}">
				<th>작성일자 </th>
				<td> ${dto.board_date }</td>
			</c:if>
			
			<c:if test="${!empty dto.board_update}">
				<th>수정일자 </th>
				<td> ${dto.board_update }</td>
			</c:if>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글수정"
				onclick="location.href='board_modify.do?no=${dto.board_no}&page=${Page }'">
				<input type="button" value="글삭제"
				onclick="if(confirm('정말로 삭제하시겠습니까?')){
					location.href='board_delete.do?no=${dto.board_no}&page=${Page }'
				}else{return ;}">
				<input type="button" value="전체목록"
				onclick="location.href='board_list.do?page=${Page}'">
			</td>
		</tr>
	</table>
	</div>

</body>
</html>