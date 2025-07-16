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
	
	
	<h1>Encoding 처리하기</h1>
		닉네임 : <input type="text" id="nick">
		<input type="button" id="btn" value="닉네임 보내기" >
		<p id="result"></p>
		
		<!-- jQuery -->
		<script>
			/*	const btn = document.querySelector("#btn")
				btn.addEventListener("click", startRequest)
				이거랑 같은 것*/
			$("#btn").click(()=> {
				const nickname = $("#nick").val();
				$.ajax({
					// 요청
					type: "get",
					url : "/encoding",
					data : "nickname=" + nickname,
					// 응답
					success: function(result){
						$("#result").text(result);
					}
				});
			});
			
		</script>
		
		<!-- get, /encoding -->
		<!--자바스크립트 <script>
			let xhr;
			function startRequest() { // 요청에 해당하는 로직을 담는 메서드
				// 입력한 닉네임 받아오기
				const nickname = document.querySelector("#nick").value;
				xhr = new XMLHttpRequest();
			    xhr.onreadystatechange = callback;
			   // 내가 입력한 닉네임 출력준비?
			    xhr.open("get", "/encoding?nickname="+ nickname);
			   	xhr.send(); // 이때 서버로 전송.. 실질적인 요청이 들어감!
			}
			
			function callback(){ // 응답에 해당하는 로직을 담는 메서드 
				if(xhr.readyState === 4) {
					if(xhr.status === 200){
						const nickname = xhr.responseText
						// result 값 불러와서 출력
						document.querySelector("#result").innerHTML = nickname;
				}
			}
			}
			const btn = document.querySelector("#btn")
			btn.addEventListener("click", startRequest)
		</script>-->
</body>
</html>