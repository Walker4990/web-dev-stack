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
		<div>
			아이디 : <input type="text" id="id"><br>
			비밀번호 : <input type="password" id="pwd"><br>
			이름 : <input type="text" id="name"><br>
			나이 : <input type="number" id="age"><br>
			<button id="btn">회원가입</button>
		</div>
		<div id="result"></div>
		<script>
		$("#btn").click(() => { // formData -> 자바스크립트의 form형식 이라고 생각하면 편함.
			const formData = new FormData();
			formData.append("id", $("#id").val());
			formData.append("pwd", $("#pwd").val());
			formData.append("name", $("#name").val());
			formData.append("age", $("#age").val());
			
			$.ajax({
						type: "post",
						url: "/register",
						data: formData,
						processData: false,
						contentType : false,
						success: function(response){
							$("#result").text(response.name + "님이 회원가입 하셨습니다.")
						},
					});
			});
		</script>
</body>
</html>