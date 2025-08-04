<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<!-- get, /myPage : 인증된 사람만 즉 ! 로그인 된 사람만 올수 있도록-->
	<h1>마이페이지</h1>
	<p><sec:authentication property="principal.id" />님의 페이지입니다.</p>
	<p><sec:authentication property="principal.name" />님의 페이지입니다.</p>
</body>
</html>