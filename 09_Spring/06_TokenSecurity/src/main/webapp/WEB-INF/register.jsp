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
	
		<h1>회원가입</h1>
		<form action="/register" method="post">
			아이디 : <input type="text" id="id" name="id"><br>
			비밀번호 : <input type="password" id="pwd" name="pwd"><br>
			이름 : <input type="text" id="name" name="name"><br>
			<button type="submit" id="btn">회원가입</button>
		</form>
		
</body>
</html>