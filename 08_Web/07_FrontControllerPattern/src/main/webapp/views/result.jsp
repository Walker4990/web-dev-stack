<%@page import="vo.Member"%>
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
	<%--views/result.jsp에서
						성공하면 해당 정보 출력
						실패하면 "검색에 실패했습니다." --%>
	<h1>회원 정보</h1>
	<c:choose>
		<c:when test="${check and not empty member}">
			<h3>아이디 : ${member.id}</h3>
			<h3>비밀번호 :${member.pwd}</h3>
			<h3>이름 : ${member.name}</h3>
			<h3>나이 : ${member.age}</h3>
		</c:when>
		<c:otherwise>
			<h2>검색에 실패했습니다.</h2>
		</c:otherwise>
	</c:choose>
	<a href="/">메인 페이지로 이동</a>
</body>
</html>