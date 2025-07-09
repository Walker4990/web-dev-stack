<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 일반 for문 버전 --%>
	<c:forEach var="i" begin="1" end="6" step="1">
		<%--    변수, 시작값, 끝값, 증가값 --%>
		<h${i}>JSTL..!</h${i}>
	</c:forEach>
	
	<%
		String [] arr = {"두루치기", "닭꼬치", "김치볶음밥", "순두부찌개"};
		request.setAttribute("arr", arr);
	%>
	<%-- 향상된 for문 버전 --%>
	<c:forEach items="${arr}" var="menu">
		<p>${menu}</p>
	</c:forEach>
</body>
</html>