<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<h3>MEMBER10 테이블 ${dto.getMemname() }회원정보 상세 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<table border="1" cellspacing="0" width="350">
		
			<tr>
				<th>회원 No.</th>
				<td> ${dto.getNum() } </td>
			</tr>
			
			<tr>
				<th>회원 아이디</th>
				<td> ${dto.getMemid() } </td>
			</tr>
			
			<tr>
				<th>회원 이름</th>
				<td> ${dto.getMemname() } </td>
			</tr>
			
			<tr>
				<th>회원 비밀번호</th>
				<td>
					<c:if test="${dto.getPwd().length() != 0 }">
						<c:forEach begin="1" end="${dto.getPwd().length()}">
							*
						</c:forEach>
					</c:if>
				</td>
			</tr>
			
			<tr>
				<th>회원 나이</th>
				<td> ${dto.getAge() } </td>
			</tr>
			
			<tr>
				<th>회원 마일리지</th>
				<td> <fmt:formatNumber value="${dto.getMileage() }"/> 포인트</td>
			</tr>
			
			<tr>
				<th>회원 직업</th>
				<td> ${dto.getJob() } </td>
			</tr>
			
			<tr>
				<th>회원 주소</th>
				<td> ${dto.getAddr() } </td>
			</tr>
			

			<tr>
				<th>회원 가입일자</th>
				<td> ${dto.getRegdate() } </td>
			</tr>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 회원정보가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원정보 수정"
					onclick="location.href='member_modify.do?num=${dto.getNum()}'">
					<input type="button" value="회원 삭제"
					onclick="if(confirm('정말로 삭제하시겠습니까?')){
						location.href='member_delete.do?num=${dto.getNum()}'
					}else{return ;}">
					<input type="button" value="전체목록"
					onclick="location.href='member_select.do'">
				</td>
				
			</tr>
		</table>
	
	</div>
</body>
</html>