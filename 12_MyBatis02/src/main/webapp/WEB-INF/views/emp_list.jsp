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
	   <hr width="50%" color="red">
	      <h3>EMP 테이블 전체 사원 리스트</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="350">
	      <tr>
	         <th>사원 No.</th> <th>이 름</th>
	      	 <th>부서 No.</th> <th>입사일자</th>
	      </tr>
	      <c:set var="list" value="${List }"/>
	      
		  <c:if test="${!empty list}">
		  <c:forEach items="${list }" var="dto">
		  <tr>
		  	<td>${dto.getEmpno() }</td>
		  	<td> <a href="<%=request.getContextPath()%>/emp_content.do?num=${dto.getEmpno()}">
		  	${dto.getEname() }</a></td>
		  	<td>${dto.deptno }</td> <!-- get을 생략하고 기존 변수명으로 사용하는것도 가능하다. -->
		  	<td>${dto.getHiredate().substring(0,10) }</td>
		  </tr>
		  </c:forEach>
		  </c:if>	
		  
		  <c:if test="${empty list}">
		  <tr>
				<td colspan="4" align="center">
					<h3>검색된 데이터가 없습니다....</h3>
				</td>		  
		  </tr>
		  </c:if>      
	   
	   		<tr>
	   		   <td colspan="4" align="center">
	   		      <input type="button" value="사원등록"
	   		         onclick="location.href='emp_insert.do'">
	   		   </td>
	   		</tr>
	   </table>
	   
	   <br>
	   
	   <form method="post" action="<%=request.getContextPath()%>/emp_search.do">
	   <select name="field">
	   <option value="empno">사번 </option>
	   <option value="name">이름 </option>
	   <option value="job">담당업무 </option>
	   </select>
	   
	   <input type="text" name="keyword">
	   <input type="submit" value="검색">
	   
	   </form>
	
	</div>
</body>
</html>