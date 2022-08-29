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
		<h3>PRODUCTS테이블 제품목록 리스트</h3>
		<hr width="50%" color="red">
		<br>
		<c:set var="list" value="${ProductList }"/>
		<table border="1" cellspacing="0" width="500">
		<tr>
			<th>제품번호</th> <th>제 품 명</th>
			<th>판매가격 </th> <th>제 조 사</th>
		</tr>
		
		<c:if test="${!empty list }">
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.getPnum() }</td>
				<td> <a href="<%=request.getContextPath()%>/product_content.do?pnum=${dto.getPnum() }">
				${dto.getProduct_name() }</a></td>
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
			<td colspan="4" align="right">
				<input type="button" value="제품등록"
				onclick="location.href='product_insert.do'">
			</td>
		</tr>
		</table>
		<br>
		<form method="post" action="<%=request.getContextPath()%>/product_search.do">
		<select name="field">
		<option value="product_name">제품명 </option>
		<option value="company">제조사 </option>
		</select>
		
		<input type="text" name="keyword">&nbsp;&nbsp;&nbsp;
		<input type="submit" value="검색">
		
		</form>
	</div>

</body>
</html>