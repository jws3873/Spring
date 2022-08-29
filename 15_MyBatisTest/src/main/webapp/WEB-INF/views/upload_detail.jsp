<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
		<h3>UPLOAD테이블 ${dto.upload_writer }님 게시글 상세 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>작성자</th>
				<td>${dto.upload_writer }</td>
			</tr>
			
			<tr>
				<th>글제목</th>
				<td>${dto.upload_title }</td>
			</tr>
			
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="7" cols="30">${dto.upload_cont }</textarea>
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<c:if test="${!empty dto.upload_pwd}">
					<c:forEach begin="1" end="${dto.upload_pwd.length() }">
						*
					</c:forEach>
					</c:if>
				</td>
			</tr>
			
			<tr>
				<th>조회수</th>
				<td>${dto.upload_hit }</td>
			</tr>
			
			<tr>
				<th>첨부파일</th>
				<td>
					<a href="resources/${dto.upload_file}">${dto.upload_file}</a>
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
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="modifyBtn" value="글수정">
				<input type="button" id="deleteBtn" value="글삭제">
				<input type="button" id="listBtn" value="전체목록">
			</td>
		</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#modifyBtn').on("click",function(){
			location.href="<c:url value='upload_modify.do?no=${dto.upload_no}'/>"
		});
		
		$('#deleteBtn').on("click",function(){
			
			if(confirm('정말로 삭제하시겠습니까?')){
				location.href="<c:url value='upload_delete.do?no=${dto.upload_no}'/>"
			}else{
				return;
			}
			
		});
		
		$('#listBtn').on("click",function(){
			location.href="<c:url value='upload_list.do'/>"
		});
	});
</script>
</html>