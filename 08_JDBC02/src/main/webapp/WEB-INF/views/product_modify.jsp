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
	<c:set var="dto" value="${Modify }"/>
	<c:set var="cartlist" value="${CartList }"/>
		<hr width="50%" color="red">
		<h3>PRODUCTS 테이블 ${dto.getProduct_name() }제품 수정 폼 페이지</h3>
		<hr width="50%" color="red">
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/product_modify_ok.do">
		<input type="hidden" name="pnum" value="${dto.getPnum() }">
		<table width="400">
			<tr>
				<th>카테고리 코드 </th>
				<td> 
					<select name="category_fk">
						<c:if test="${!empty cartlist}">
						<c:forEach items="${cartlist }" var="cartdto">
						<c:if test="${cartdto.getCategory_code() == dto.getCategory_fk() }">
						<option value="${cartdto.getCategory_code() }" selected >${cartdto.getCategory_name() }[${cartdto.getCategory_code() }] </option>
						</c:if>
						
						<c:if test="${cartdto.getCategory_code() != dto.getCategory_fk() }">
						<option value="${cartdto.getCategory_code() }" disabled>${cartdto.getCategory_name() }[${cartdto.getCategory_code() }] </option>
						</c:if>
						</c:forEach>
						</c:if>
						<c:if test="${empty cartlist}">
						<option value="">:::카테고리 코드 없음::: </option>
						</c:if>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>제품명 </th>
				<td> 
					<input type="text" name="product_name" value="${dto.getProduct_name()}" readonly>
				</td>
			</tr>
			
			<tr>
				<th>제품 코드 </th>
				<td> 
					<input type="text" name="ep_code_fk" value="${dto.getEp_code_fk()}" readonly>
				</td>
			</tr>
			
			<tr>
				<th>제품 입고 가격 </th>
				<td> 
					<input type="text" name="input_price" value="${dto.getInput_price()}"> 원
				</td>
			</tr>
			
			<tr>
				<th>제품 출고 가격 </th>
				<td> 
					<input type="text" name="output_price" value="${dto.getOutput_price()}"> 원
				</td>
			</tr>
			
			<tr>
				<th>제품 배송비</th>
				<td> 
					<input type="text" name="trans_cost" value="${dto.getTrans_cost()}"> 원
				</td>
			</tr>
			
			<tr>
				<th>제품 마일리지</th>
				<td> 
					<input type="text" name="mileage" value="${dto.getMileage()}"> 마일리지
				</td>
			</tr>
			
			<tr>
				<th>제품 제조사</th>
				<td> 
					<input type="text" name="company" value="${dto.getCompany()}" readonly> 
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="제품수정"> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시작성">
				</td>
			</tr>
			
		</table>
		
		</form>
	</div>
</body>
</html>