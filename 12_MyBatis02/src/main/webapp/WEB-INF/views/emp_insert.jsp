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
	<c:set var="joblist" value="${jobList }"/>
	<c:set var="mgrlist" value="${mgrList }"/>
	<c:set var="deptlist" value="${deptList }"/>
	
		<hr width="50%" color="red">
		<h3>EMP테이블 사원 등록 폼</h3>
		<hr width="50%" color="red">
		<br>
		
		<form method= "post" action="<%=request.getContextPath()%>/emp_insert_ok.do">
		<table border="1" cellspacing="0" width="350">
		<tr>
			<th>사원No.</th>
			<td>
				<input type="text" name="empno">
			</td>
		</tr>
		
		<tr>	
			<th>사원명</th>
			<td>
				<input type="text" name="ename">
			</td>
		</tr>
		
		<tr>	
			<th>담당업무</th>
			<td>
				<select name="job">
				<c:if test="${!empty joblist }">
				<c:forEach items="${joblist }" var="job">
				<option value="${job }">${job }</option>
				</c:forEach>				
				</c:if>
				
				<c:if test="${empty joblist }">
				<option value="">:::담당업무가 없습니다::: </option>
				</c:if>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>관리자 No. </th>
			<td> 
			<select name="mgr">
			<c:if test="${!empty mgrlist }">
			<c:forEach items="${mgrlist }" var="mgrdto">
			<option value="${mgrdto.getEmpno() }">${mgrdto.getEname()}[${mgrdto.getEmpno() }]</option>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty mgrlist }">
			<option value=" ">:::관리자 없음:::</option>
			</c:if>
			</select>
			</td>
		</tr>
		
		<tr>
			<th>급여</th>
			<td>
				<input type="text" name="sal">			
			</td>
		</tr>
		
		<tr>
			<th>보너스</th>
			<td>
				<input type="text" name="com">			
			</td>
		</tr>
		
		<tr>
			<th>부서번호 </th>
			<td>
				<select name="deptno">
					<c:if test="${!empty deptlist }">
					<c:forEach items="${deptlist }" var="deptdto">
						<option value="${deptdto.getDeptno() }">${deptdto.getDname() }[${deptdto.getDeptno() }]</option>
					</c:forEach>
					</c:if>
				</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="사원등록"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시작성">
			</td>
		</tr>
		</table>
		</form>
	
	</div>
</body>
</html>