<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="red">
		<h3>BOARD 테이블 메인 페이지</h3>
		<hr width="50%" color="red">
		
		<a href="<%=request.getContextPath()%>/board_list.do">[전체 게시글]</a>
				
	</div>
</body>
</html>
