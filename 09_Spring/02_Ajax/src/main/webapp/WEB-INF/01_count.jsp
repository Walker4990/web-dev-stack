<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
</head>
<body>
	<!-- Ajax(Asynchronous JavaScript and Xml) : 비동기적 정보 교환 기법-->
	<h1>Count</h1>
	<input type="button" id="btn" value="증가" onclick="startRequest()">
	<p id="result"></p>
	
	<!-- 자바스크립트 방식 -->
	<script>
		let xhr;
		function startRequest(){ // 요청에 해당하는 로직을 담는 메서드
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open("get", "/count");
			xhr.send(null); // 이때 서버로 전송.. 실질적인 요청이 들어감!
		}
		
		function callback(){ // 응답에 해당하는 로직을 담는 메서드 
			if(xhr.readyState === 4) {
				if(xhr.status === 200){
					const count = xhr.responseText
					document.querySelector("#result").innerHTML = count;
				
				
				/*
				상태 코드
				2로 시작하는 애들 : 성공
				4로 시작하는 애들 : 실패(화면단 문제, 요청 미스)
				5로 시작하는 애들 : 실패(서버단 에러)
				*/
			}
			
		}
		}
	</script>
</body>
</html>