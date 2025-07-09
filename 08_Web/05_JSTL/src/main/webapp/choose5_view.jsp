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
	<%-- c:if 사용했을 경우
		1이 들어오면 " 안녕하세요~" 출력
		2가 들어오면 " 처음 뵙겠습니다" 출력
		그외에는 "모르는 사람인데요.." 출력 --%>
	<c:if test="${param.number eq'1'}">
		<p>안녕하세요~</p>
	</c:if>
	<c:if test="${param.number eq'2'}">
		<p>처음 뵙겠습니다.</p>
	</c:if>
	<c:if test="${param.number ne '1' and param.number ne '2'}">
		<p>모르는 사람인데요..</p>
	</c:if>

	<%--
	 	== : eq, != : ne, < : lt, > : gt, <= : le, >= : ge
	 	&& : and, || : or, ! : not,
	 	== null : empty - null이거나 빈 문자열인 경우 true
	 	!= null : not empty
	  --%>
	<%-- c:choose 사용 --%>
	
	<c:choose>
		<c:when test="${param.number eq'1'}">
			<p>안녕하세요~</p>
		</c:when>
		<c:when test="${param.number eq'2'}">
			<p>처음 뵙겠습니다</p>
		</c:when>
		<c:otherwise>
			<p>모르는 사람인데요..</p>
		</c:otherwise>


	</c:choose>
</body>
</html>