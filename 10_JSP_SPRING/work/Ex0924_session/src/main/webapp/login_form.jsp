<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="js/httpRequest.js"></script>
<script>
	function send(f){
		let userid = f.userid.value.trim();
		let pwd = f.pwd.value.trim();
		
		let url = "login.do";
		let param = "userid="  + encodeURIComponent(userid) + "&pwd=" + encodeURIComponent(pwd);
		sendRequest( url, param, resultFn, "post");
	}
	function resultFn(){
		
		if( xhr.readyState ==4 && xhr.status == 200){
			
			let data = xhr.responseText;
			let json = JSON.parse(data);
			
			if ( json[0].param == 'no_id') {
				alert('아이디가 일치하지 않습니다.')
			} else if (json[0].param == 'no_pwd'){
				alert('비밀번호가 일치하지 않습니다.')
			} else {
				location.href="main_content.jsp";
			}
		}
	}
</script>

<body>
	<form>
		<table border="1">
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input name='userid' >
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name='pwd' type="password" >
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="로그인"
					onClick="send(this.form)" />
				<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>