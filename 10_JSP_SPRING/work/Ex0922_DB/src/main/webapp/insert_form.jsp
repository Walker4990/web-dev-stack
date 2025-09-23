<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function send(f){
		let name = f.name.value;
	    let kor  = f.kor.value;
        let eng  = f.eng.value;
        let mat  = f.mat.value;
        
		if (name=="") {
			alert("이름을 입력하세요");
			return;
		} 
		if (kor=="") {
			alert("국어 점수를 입력하세요");
			return;
	}
		if (eng=="") {
			alert("국어 점수를 입력하세요");
			return;
	}
		if (mat=="") {
			alert("국어 점수를 입력하세요");
			return;
	}
		f.action = 'sj_register.do';
		f.submit();
	}
</script>
<body>
	<form action="">
		<table border="1">
		<tr>
			<th>이름</th>
			<td><input name="name" /></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><input name="kor" /></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><input name="eng" /></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><input name="mat" /></td>
		</tr>
		<tr>
			
			<td><input type="button" value="확인" 
			onclick="send(this.form);" /></td>
		</tr>
		</table>
	</form>
</body>
</html>