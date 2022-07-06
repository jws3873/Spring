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
	<c:set var="dto" value="${Cont }"/>
	<div align="center">
		<hr width="50%" color="red">
		<h3>UPLOAD 테이블 ${dto.upload_writer }님 게시글 수정 폼 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="450">
		<tr>
			<th>작성자 </th>
			<td>${dto.upload_writer } </td>
		</tr>
		
		<tr>
			<th>글제목 </th>
			<td>${dto.upload_title } </td>
		</tr>
		
		<tr>
			<th>글내용 </th>
			<td> <textarea rows="7" cols="30">${dto.upload_cont }</textarea> </td>
		</tr>
		
		<tr>
			<th>비밀번호 </th>
			<td>
				<c:if test="${!empty dto.upload_pwd}">
				<c:forEach begin="1" end="${dto.upload_pwd.length()}">
					*
				</c:forEach>				
				</c:if>			
			</td>
		</tr>
		
		<tr>
			<th>조회수 </th>
			<td> ${dto.upload_hit }</td>
		</tr>
		
		<tr>
			<th>첨부파일 </th>
			<td>
				<a href="${dto.upload_file }" target="_blank">${dto.upload_file.substring(17) }</a>			
			</td>
		</tr>
		
		<tr>
			<c:if test="${empty dto.upload_update }">
			<th>작성일자</th>
			<td> ${dto.upload_date } </td>
			</c:if>
			
			<c:if test="${!empty dto.upload_update }">
			<th>수정일자</th>
			<td> ${dto.upload_update } </td>
			</c:if>
		</tr>
		
		<c:if test="${empty dto }">
			<tr>
				<td colspan="2" align="center">
				<h3>검색된 게시글이 없습니다....</h3>
				</td>
			</tr>
		</c:if>
		
		<tr>
			<td colspan="2" align="center">
			<input type="button" value = "글수정"
				onclick="location.href='upload_update.do?no=${dto.upload_no}'">
			
			<input type="button" value="글삭제"
				onclick = "if(confirm('게시글을 삭제하시겠습니까?')){
					location.href='upload_delete.do?no=${dto.upload_no}'
				}else{return ;}">
				
			<input type="button" value="전체목록"
				onclick="location.href='upload_list.do'">
			</td>
		</tr>
		</table>
	</div>
</body>
</html>