<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
		<h1>회원가입</h1>
		<form id="frm">
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="password" name="pwd"><br>
			이름 : <input type="text" name="name"><br>
			나이 : <input type="age" name="age"><br>
			<input type="button" value="회원가입" id="btn">
		</form>
		<div id="result"></div>
		<script>
		$("#btn").click(() => {
			$.ajax({
						type: "post",
						url: "/signup",
						data: $("#frm").serialize(),
						success: function(response){
							$("#result").text(response.name + "님이 회원가입 하셨습니다.")
						},
					});
			});
		</script>
</body>
</html>