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
		<hr width="50%" color="red">
		<h3>PRODUCTS테이블 제품검색목록 리스트</h3>
		<hr width="50%" color="red">
		<br>
		<c:set var="list" value="${searchList }"/>
		<table border="1" cellspacing="0" width="500">
		<tr>
			<th>제품번호</th> <th>제 품 명</th> <th>입고가격</th>
			<th>판매가격 </th> <th>제 조 사</th>
		</tr>
		
		<c:if test="${!empty list }">
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.getPnum() }</td>
				<td>${dto.getProduct_name() }</td>
				<td> <fmt:formatNumber value="${dto.getInput_price() }"/>원</td>
				<td> <fmt:formatNumber value="${dto.getOutput_price() }"/>원</td>
				<td>${dto.getCompany() }</td>
			</tr>
		</c:forEach>
		</c:if>
		
		<c:if test="${empty list }">
			<tr>
				<td colspan="4" align="center">
					<h3>검색된 제품정보가 없습니다.....</h3>
				</td>
			</tr>
		</c:if>
		
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="전체목록"
				onclick="location.href='product_list.do'">
			</td>
		</tr>
		</table>

	</div>
</body>
</html>