<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function send(f){
    
	let name = f.name.value;
	if (name==''){
		alert("이름을 입력하세요")
		return;
	}
	f.action = "register.do";
	f.method = "post";
	f.submit();
}
</script>
<form>
	<table border ='1'>
		
		<tr>
			<th>이름</th>
			<td><input name="name" /></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input name="userid" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name="pwd" type = "password"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input name="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input name="addr" /></td>
		</tr>
			<tr>
			<td colspan="2"><input type="button" value="등록" 
			onclick="send(this.form);" />
			<input type="button" value="취소" onClick="history.go(-1)"/></td>
		</tr>
	</table>
	</form>
</body>
</html>