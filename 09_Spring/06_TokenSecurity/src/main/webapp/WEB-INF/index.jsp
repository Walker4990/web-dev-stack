<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
		<div id="anonymous" style="display: none;">
		<sec:authorize access="isAnonymous()">
		<a href="/register"> 회원가입</a><br>
		<a href="/login"> 로그인<a><br>
		</sec:authorize>
		</div>
		</when>
		<div id="authenticated" style="display: none;">
		<sec:authorize access="isAuthenticated()">
		<a href="/logout">로그아웃</a><br>
		<a href="/myPage">마이페이지</a><br>
		</sec:authorize>
				
		<sec:authorize access="hasRole('ADMIN')">
		<a href="/admin">관리자 페이지</a><br>
		</sec:authorize>
		</div>
		<script>
			const token = localStorage.getItem("token");
			if(token!==null){
				$("#authenticated").show();
			} else {
				$("#anonymous").show();	
			}
		</script>
</body>
</html>