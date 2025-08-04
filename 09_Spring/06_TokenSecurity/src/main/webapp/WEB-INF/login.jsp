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
	<!-- 로그인에 성공하면 index.jsp에 ~님 로그인 하셨습니다. 
		기존 회원가입이랑 로그인 연결된 부분은 사라지고
	-->
	<h1>로그인</h1>
		<form action="/login" method="post" id="frm">
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type ="password" name="pwd"><br>
			<button type="submit" id="btn" value="로그인">로그인</button>
			</form>
	<script>
		$("#btn").click((e) => {
			e.preventDefault(); // 기존 이벤트 제거
			
			$.ajax({
				type: "POST",
				url:"/login",
				data: $('#frm').serialize(),
				success:function(data){
					// localStorage에 token 키 값으로 저장
					localStorage.setItem("token", data);
					// <- index.jsp로 이동
					location.herf="/";
					}
				}, error: function(){
					alert("서버 오류");
				}
			})
			
		})
	</script>
			
</body>
</html>